package com.curiousapps.footsies.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.curiousapps.footsies.domain.StudentItem
import com.curiousapps.footsies.domain.StudentRepository
import com.curiousapps.footsies.util.IO_DISPATCHER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HogwartViewModel @Inject constructor(
    private val studentRepository: StudentRepository
): ViewModel() {

    private val _state = MutableStateFlow(HogState())
    val state = _state
        .onStart { fetchAllStudents() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000L),
            HogState()
        )

    private fun fetchAllStudents(){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = studentRepository.fetchAllStudents()
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        hogItem = result.getOrNull()!!,
                        isLoading = false
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        hogItem = emptyList(),
                        isLoading = false
                    ) }
                }
            }
        }
    }


    data class HogState(
        val hogItem: List<StudentItem> = emptyList(),
        val isLoading: Boolean = true
    )
}