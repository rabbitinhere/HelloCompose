package com.rabbitinhere.hellocompose

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemeBlue
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemePink
import com.rabbitinhere.hellocompose.theme.MyCustomeMaterialTheme
import com.rabbitinhere.hellocompose.theme.myExtraColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCustomMaterialThemeBlue {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding))) {
            Image(
                painter = painterResource(R.drawable.cat11),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.myExtraColor,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                color = MaterialTheme.colors.primary) {
                    Text(text = msg.body, style = MaterialTheme.typography.body2)
                }
            }
        }
    }

    @Preview("Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Light Mode")
    @Composable
    fun PreviewMessageCard() {
        MyCustomMaterialThemeBlue {
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
            )
        }
    }

    data class Message(val author: String, val body: String)
}
