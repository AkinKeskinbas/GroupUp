package com.keak.anichat.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.animeson.anichat.R

// Set of Material typography styles to start with
val Rubic = FontFamily(
    Font(R.font.rubic_regular, FontWeight.Normal),
    Font(R.font.rubic_medium, FontWeight.Medium),
    Font(R.font.rubic_light, FontWeight.Light),
    Font(R.font.rubic_bold, FontWeight.Bold),
    Font(R.font.rubic_black, FontWeight.Black),
    Font(R.font.rubic_extra_bold, FontWeight.ExtraBold),
    Font(R.font.rubic_semi_bold, FontWeight.SemiBold)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 25.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 25.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 25.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Rubic,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 41.sp

    )
)