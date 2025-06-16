package com.curiousapps.footsies.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.curiousapps.footsies.ui.presentation.component.Background
import com.curiousapps.footsies.ui.presentation.component.HeaderImage
import com.curiousapps.footsies.ui.presentation.component.TitleText

@Composable
fun HogDetailScreen(
    studentItem: String,
    modifier: Modifier = Modifier,
    navController: NavController
){
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
    }


}