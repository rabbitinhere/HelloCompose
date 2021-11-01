package com.rabbitinhere.hellocompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemeBlue

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCustomMaterialThemeBlue {
                Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
            }
        }
    }

    @Preview
    @Composable
    fun TextWithPaddingToBaselinePreview() {
        MyCustomMaterialThemeBlue {
            Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
        }
    }

    @Preview
    @Composable
    fun TextWithNormalPaddingPreview() {
        MyCustomMaterialThemeBlue {
            Text("Hi there!", Modifier.padding(top = 32.dp))
        }
    }

    fun Modifier.firstBaselineToTop(
        firstBaselineToTop: Dp
    ) = this.then(
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            // Check the composable has a first baseline
            check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
            val firstBaseline = placeable[FirstBaseline]

            // Height of the composable with padding - first baseline
            val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
            val height = placeable.height + placeableY
            layout(placeable.width, height) {
                // Where the composable gets placed
                placeable.placeRelative(0, placeableY)
            }
        }
    )


}
