package com.rabbitinhere.hellocompose

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemeBlue
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemePink
import com.rabbitinhere.hellocompose.theme.MyCustomeMaterialTheme
import com.rabbitinhere.hellocompose.theme.myExtraColor
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCustomMaterialThemeBlue {
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Message>){
        var shouldShowTitle by rememberSaveable { mutableStateOf(true) } //并不是真的持久化，因为推出app再进就恢复了。感觉就是一个在Application层面的内存

        Column{
            if(shouldShowTitle) {
                Text(text = "show first, click dismiss", Modifier.clickable {
                    shouldShowTitle = false
                })
            }
            LazyColumn{
                items(messages){ message ->
                    MessageCard(message)
                }
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
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember { mutableStateOf(false)}
            val sufaceColor: Color by animateColorAsState(if(isExpanded) MaterialTheme.colors.surface else MaterialTheme.colors.primary)

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.myExtraColor,
                    style = MaterialTheme.typography.subtitle2,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                color = sufaceColor) {
                    Text(text = msg.body, style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp),
                    maxLines = if(isExpanded) Int.MAX_VALUE else 1)
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

    @Preview("Conversation")
    @Composable
    fun PreviewConversation()
    {
        MyCustomMaterialThemeBlue {
            Conversation(messages = SampleData.conversationSample)
        }
    }

    @Preview(
        name = "BOX"
    )
    @Composable
    fun PreviewBOX()
    {
        MyCustomMaterialThemeBlue {
            myBox()
        }
    }

    @Composable
    private fun myBox()
    {
        Box(modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(50.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.cat11),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
            Text("left start", modifier = Modifier.align(Alignment.TopStart))

            Text("center bottom", modifier = Modifier.align(Alignment.BottomCenter))
            Text("right bottom", modifier = Modifier.align(Alignment.BottomEnd))

        }
    }

    @Preview(name = "dick")
    @Composable
    private fun preDick()
    {
        dick()
    }


    @Composable
    private fun dick()
    {
        MyCustomMaterialThemeBlue {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = Color.Gray,
                    center = Offset(x = canvasWidth / 2 - 200, y = canvasHeight / 2 + 200),
                    radius = size.minDimension / 4
                )

                drawCircle(
                    color = Color.Gray,
                    center = Offset(x = canvasWidth / 2 + 200, y = canvasHeight / 2 + 200),
                    radius = size.minDimension / 4
                )

                val x = (canvasWidth - 500F) / 2
                drawRoundRect(
                    color = Color.Gray,
                    topLeft = Offset(x, 100F),
                    size = Size(500F, 1000F),
                    cornerRadius = CornerRadius(size.minDimension / 4)
                )
            }
        }
    }

}
