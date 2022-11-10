package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme{
                Surface(color = Color.White) {
                    ComposeArticleApp()
                }
            }

        }
    }
}

@Composable
fun ComposeArticleApp() { ArticleCard(stringResource(id = R.string.title_jetpack_compose_tutorial), stringResource(id = R.string.compose_short_desc), stringResource(id = R.string.compose_long_desc), painterResource(id = R.drawable.bg_compose_background), modifier = Modifier.background(Color.White) ) }

@Composable
private fun ArticleCard(title: String, shortDescription: String, longDescription: String, imagePainter: Painter, modifier: Modifier = Modifier, ) {
    Column() {
        // 이미지 영역
        Image(painter = imagePainter, contentDescription = null)
        // 타이틀 영역
        Text(text = title, fontSize = 24.sp , modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.Start)
            .padding(all = 16.dp))
        // 중간 영역
        Text(text = shortDescription ,modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = longDescription ,modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.Bottom)
            .padding(all = 16.dp), textAlign = TextAlign.Justify)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleCard(stringResource(id = R.string.title_jetpack_compose_tutorial), stringResource(id = R.string.compose_short_desc), stringResource(id = R.string.compose_long_desc), painterResource(id = R.drawable.bg_compose_background), Modifier )
}