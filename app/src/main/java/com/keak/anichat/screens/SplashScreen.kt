package com.keak.anichat.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.keak.geniusai.navigation.Router

@Composable
fun SplashScreen(router: Router) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Splash Screen", color = Color.Black)
    }
}