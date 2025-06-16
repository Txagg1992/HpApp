package com.curiousapps.footsies.ui.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.curiousapps.footsies.R

@Composable
fun Background(){

    val background = Brush.verticalGradient(
        listOf(
            Color.LightGray,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Blue,
        )
    )
    Box(
        modifier = Modifier.fillMaxSize().background(background)
    )
}