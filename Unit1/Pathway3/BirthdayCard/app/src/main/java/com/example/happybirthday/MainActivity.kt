/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import android.text.Layout
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(stringResource(R.string.card_message), stringResource(R.string.user_name))
                }
            }
        }
    }
}

// 7. 텍스트 정렬 및 패딩 추가
@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    // Row 가로
//    Row {
//        Text(text = "$message $from 1", fontSize = 20.sp)
//        Text(text = "$message $from 2", fontSize = 20.sp)
//        Text(text = "$message $from 3", fontSize = 20.sp)
//        Text(text = "$message $from 4", fontSize = 20.sp)
//    }
    // Col 세로
    Column {
        // modifier 및 ContentScale를 통해 위치 지정 및 크기 조정을 할 수 있다.
        Text(text = message,
            fontSize = 36.sp,
//            modifier = Modifier.background(color = Color.Green),
            // constraint 라고 생각하면 될듯??
            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally).padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally).padding(start = 16.dp, end = 16.dp)
        )
    }
}

// 5. Box 레이아웃 추
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty) // painterResource로 drawable 리소스 접근
    // box 레이아웃을 통해 요소를 박스처럼 쌓을 수 있다. , 특정 정렬도 구성 가능
    Box {
        // painter : 리소스  ,  contentDescription : 사용자에게 표시되는 콘텐츠 설정 ( null 선언 시 톡백 생략 )
        // modifier 및 ContentScale를 통해 위치 지정 및 크기 조정을 할 수 있다.
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            contentScale = ContentScale.Crop // Crop 속성 추가
        )
        BirthdayGreetingWithText(message,from)
    }
}

// 4. 이미지 컴포저블 추가
@Preview(name = "My Preview", showBackground = false)
@Composable
private fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage("Happy Birthday","-from MyeongSeong")
    }
}

@Composable
fun Greeting(name : String){
    Text(text = "Hello $name!")
}