package com.rabbitinhere.hellocompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rabbitinhere.hellocompose.theme.RabbitTheme
import com.rabbitinhere.hellocompose.theme.RabbitThemePink
import com.rabbitinhere.hellocompose.theme.RabbitThemeYellow

class RabbitThemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RabbitThemePink {
                SampleLayout()
            }
        }
    }

    @Composable
    fun SampleLayout() {
        Column {
            Text(text = "sample", modifier = Modifier.background(color = RabbitTheme.colors.raFirstColor))
            Text(text = "des", modifier = Modifier.background(color = RabbitTheme.colors.raSecColor))
        }
    }

    @Preview
    @Composable
    fun ConstraintLayoutContentPinkPreview() {
        RabbitThemePink {
            SampleLayout()
        }
    }

    @Preview
    @Composable
    fun ConstraintLayoutContentYellowPreview() {
        RabbitThemeYellow {
            SampleLayout()
        }
    }
}
