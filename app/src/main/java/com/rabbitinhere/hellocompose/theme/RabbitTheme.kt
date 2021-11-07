package com.rabbitinhere.hellocompose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposematerial.ui.theme.*

class RabbitColorPalette(
    val raFirstColor: Color,
    val raSecColor: Color,
    val raOnFirstColor: Color,
    val raOnSecColor: Color
    )

val rabbitPurple = RabbitColorPalette(Purple200,Purple500,Purple700,Teal200)
val rabbitYellow = RabbitColorPalette(yellow200,yellow400,yellow500,yellowDarkPrimary)

val rabbitColors = compositionLocalOf<RabbitColorPalette>{
    rabbitPurple
}

@Composable
fun RabbitThemePink(
    content: @Composable() () -> Unit
) {
    val colors = rabbitPurple
    CompositionLocalProvider(rabbitColors provides colors){
        MaterialTheme(
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object RabbitTheme{
    val colors: RabbitColorPalette
        @Composable get() = rabbitColors.current
}

@Composable
fun RabbitThemeYellow(
    content: @Composable() () -> Unit
) {
    val colors = rabbitYellow
    CompositionLocalProvider(rabbitColors provides colors){
        MaterialTheme(
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}