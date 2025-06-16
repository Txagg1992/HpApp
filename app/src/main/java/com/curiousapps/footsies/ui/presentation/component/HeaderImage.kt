package com.curiousapps.footsies.ui.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.curiousapps.footsies.R

@Composable
fun HeaderImage(
    modifier: Modifier = Modifier,
    text: String
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ){
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.harry_potter_title),
            contentDescription = "Harry Potter",
        )
        TitleText(text = text)
    }

}