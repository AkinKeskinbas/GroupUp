package com.keak.anichat.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun String.limitText(selectedMaxLength:Int=9):AnnotatedString{
    val annotatedString = buildAnnotatedString {
        if (this@limitText.length > selectedMaxLength) {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(this@limitText.substring(0, selectedMaxLength))
            }
            append("...")
        } else {
            append(this@limitText)
        }
    }
    return annotatedString
}