package com.keak.anichat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PopularPeopleCircle(imageLink: String, userName: String, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        AsyncImage(
            model = imageLink,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .background(color = Color.White),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        val limitedText = userName.limitText(10)
        Text(
            text = limitedText,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.width(50.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PopularPeopleCirclePreview() {
    PopularPeopleCircle(
        imageLink = "https://i.pinimg.com/564x/36/29/0d/36290d88a3d2b3fc0f062bf2634962fa.jpg",
        userName = "WanHeda",
        modifier = Modifier
    )
}