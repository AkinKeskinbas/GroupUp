package com.keak.anichat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverlappingMoreBox(morePeopleCount:Int, imageSize:Int=30, fontSize:Int=14) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(imageSize.dp)
            .height(imageSize.dp)
            .border(width = 1.dp, color = Color.Black, shape = CircleShape)
            .clip(CircleShape)
            .background(Color.White),

        ) {
        Text(
            text = "$morePeopleCount+",
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            )
    }
}