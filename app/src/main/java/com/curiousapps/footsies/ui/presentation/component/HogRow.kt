package com.curiousapps.footsies.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.curiousapps.footsies.R
import com.curiousapps.footsies.domain.StudentItem

@Composable
fun HogRow(
    studentItem: StudentItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(studentItem.image)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_camera)
                    .error(R.drawable.ic_error_outline)
                    .build(),
                contentDescription = studentItem.name,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Name: ${studentItem.name}",
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "House: ${studentItem.house}",
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Patronus: ${studentItem.patronus}",
                fontSize = 20.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}