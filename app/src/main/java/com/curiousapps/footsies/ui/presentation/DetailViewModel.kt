package com.curiousapps.footsies.ui.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class DetailViewModel @Inject constructor(

    private val studentRepository: StudentRepository
): ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state = _state
        .onStart {  }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000L),
            DetailState()
        )

     fun fetchOneStudent(id: String){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = studentRepository.fetchOneStudent(id)
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        selectStudent = result.getOrNull()!!
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        selectStudent = emptyList()
                    ) }
                    Log.e("HogwartViewModel", "Load failed")
                }
            }
        }
    }

    data class DetailState(
        val selectStudent: List<StudentItem> = emptyList()
    )
}