package com.rabbitinhere.hellocompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.rabbitinhere.hellocompose.theme.MyCustomMaterialThemeBlue

class IntrinsicSizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCustomMaterialThemeBlue {
                Surface {
                    TwoTexts(text1 = "Hi", text2 = "there")
                }
            }
        }
    }

    /**
     * 这个例子为了让中间的分割线，刚好有两边Text控件那么高。
     *
     * 由于在绘制的时候，分割线不知道Text到底有多高。这时候就要用到IntrinsicSize：
     * 1.Row添加modifier.height(IntrinsicSize.Min): 意思是所有子view要被强制约束高度为他们的固有高度们的最大值
     *      (固有高度：就是一个控件自己必须要占的高度，比如Text的固有高度取决于他文本多大。下面的分割线由于没给定具体height，所以他的固有高度是0.)
     * 2.浴室只要让分割线高度是铺满，就铺满到他的父布局Row的高度了，Row的高度由于IntrinsicSize已经被固定了所以就可以达到要求。
     */
    @Composable
    fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
        Row(modifier = modifier.height(IntrinsicSize.Min)) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = text1
            )

            Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(1.dp))
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = text2
            )
        }
    }

    @Preview
    @Composable
    fun TwoTextsPreview() {
        MyCustomMaterialThemeBlue {
            Surface {
                TwoTexts(text1 = "Hi", text2 = "there")
            }
        }
    }
}
