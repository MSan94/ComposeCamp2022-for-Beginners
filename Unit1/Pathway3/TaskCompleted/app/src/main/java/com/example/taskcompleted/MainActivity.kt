package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StyleRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.ui.theme.TaskCompletedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               TaskCompletedTheme {
                   Surface(color = Color.White) {
                       TaskCompletedScreen(stringResource(
                           id = R.string.all_task_completed) ,
                           stringResource(id = R.string.nice_work),
                           painterResource(id = R.drawable.ic_task_completed)
                       )
                   }
               }

        }
    }
}


//<string name="all_task_completed">All tasks completed</string>
//<string name="nice_work">Nice work!</string>

@Composable
fun TaskCompletedScreen(textTop : String, textBottom : String, img : Painter)  {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = img, contentDescription = null,
        modifier = Modifier.wrapContentHeight())
        Text(
            text = textTop,
            fontSize = 24.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.Start)
                .padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = textBottom,
            fontSize = 16.sp,
            modifier = Modifier.wrapContentWidth(Alignment.Start)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCompletedScreen(stringResource(
        id = R.string.all_task_completed) ,
        stringResource(id = R.string.nice_work),
        painterResource(id = R.drawable.ic_task_completed)
    )
}