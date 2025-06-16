package com.curiousapps.footsies.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.curiousapps.footsies.ui.presentation.component.Background
import com.curiousapps.footsies.ui.presentation.component.HeaderImage
import com.curiousapps.footsies.ui.presentation.component.HogRow
import com.curiousapps.footsies.ui.presentation.component.TitleText

@Composable
fun HogListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HogwartViewModel = hiltViewModel(),
    maxImageSize: Dp = 150.dp,
    minImageSize: Dp = 50.dp
) {
    val state by viewModel.state.collectAsState(HogwartViewModel.HogState())
    val studentList = state.hogItem

    var currentImageSize by remember { mutableStateOf(maxImageSize) }
    var imageScale by remember { mutableFloatStateOf(1f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y.toInt()
                val newImageSize = currentImageSize + delta.dp
                val previousImageSize = currentImageSize

                currentImageSize = newImageSize.coerceIn(minImageSize, maxImageSize)
                val consumed = currentImageSize - previousImageSize

                imageScale = currentImageSize / maxImageSize

                return Offset(0f, consumed.value)
            }
        }
    }

    Background()
    if (state.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier.nestedScroll(nestedScrollConnection)
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 32.dp)
        ) {
            LazyColumn(
              modifier = Modifier
                  .fillMaxSize()
                  .offset {
                      IntOffset(0, currentImageSize.roundToPx())
                  }
            ) {
                val count = studentList.size
                items(count){ index ->
                    HogRow(
                        modifier = Modifier.clickable {
                            navController.navigate(
                                "hog_detail_screen/${studentList[index].name}"
                            )
                        },
                        studentItem = studentList[index]
                    )
                }
            }
            HeaderImage(
                modifier = modifier
                    .width(300.dp)
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        scaleX = imageScale
                        scaleY = imageScale
                        translationY = -(maxImageSize.toPx() - currentImageSize.toPx()) / 2f
                    },
                text = "Characters"
            )
        }
    }
}