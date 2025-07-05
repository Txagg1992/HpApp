package com.curiousapps.footsies.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.curiousapps.footsies.R
import com.curiousapps.footsies.ui.presentation.component.Background
import com.curiousapps.footsies.ui.presentation.component.HeaderImage

@Composable
fun HogDetailScreen(
    studentItem: String,
    id: String,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsState(DetailViewModel.DetailState())
    val selectedItem = state.selectStudent

    viewModel.fetchOneStudent(id = id)
    Background()
    Column(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 48.dp),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back",
            tint = Color.Yellow,
            modifier = modifier.size(48.dp)
                .offset(16.dp, 16.dp)
                .align(Alignment.Start)
                .padding(bottom = 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
        HeaderImage(text = "You selected: ")
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = studentItem,
            fontSize = 32.sp,
            color = Color.Yellow
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            val count = selectedItem.size
            items(count) { index ->
                AsyncImage(
                    model = coil.request.ImageRequest.Builder(context)
                        .data(selectedItem[index].image)
                        .placeholder(R.drawable.ic_camera)
                        .error(R.drawable.ic_error_outline)
                        .crossfade(true)
                        .build(),
                    contentDescription = studentItem,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 24.dp)
                )
            }
        }
    }
}