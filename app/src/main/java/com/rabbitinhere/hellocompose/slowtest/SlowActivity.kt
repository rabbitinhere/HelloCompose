package com.rabbitinhere.hellocompose.slowtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemeBlue

class SlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                    LazyColumn{
                        items(300){ index ->
                            Row(Modifier.padding(top = 30.dp)){
                                for(i in 0..22){
                                    Surface(
                                        shape = MaterialTheme.shapes.small,
                                        border = BorderStroke(
                                            width = 1.dp,
                                            color = Color.Red
                                        ),
                                        modifier = Modifier
                                            .padding(vertical = 2.dp)
                                    ){
                                        Column{
                                            Text("$index Text", maxLines = 1)
                                            Text("$index Text", maxLines = 1)
                                            Text("$index Text", maxLines = 1)
                                            Text("$index Text", maxLines = 1)
                                        }
                                    }
                                }

                            }
                        }
                    }

            }
        }
    }


}
