package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                ComposeQuadrantApp()
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(stringResource(id = R.string.first_title), stringResource(id = R.string.first_description), androidx.compose.ui.graphics.Color.Green, modifier = Modifier.weight(1f))
            ComposableInfoCard(stringResource(id = R.string.second_title), stringResource(id = R.string.second_description), androidx.compose.ui.graphics.Color.Yellow, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(stringResource(id = R.string.third_title), stringResource(id = R.string.third_description), androidx.compose.ui.graphics.Color.Cyan, modifier = Modifier.weight(1f))
            ComposableInfoCard(stringResource(id = R.string.fourth_title), stringResource(id = R.string.fourth_description), androidx.compose.ui.graphics.Color.LightGray, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = description, textAlign = TextAlign.Justify)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantApp()
}

//<string name="first_title">Text composable</string>
//<string name="first_description">Displays text and follows Material Design guidelines.</string>
//<string name="second_title">Image composable</string>
//<string name="second_description">Creates a composable that lays out and draws a given Painter class object.</string>
//<string name="third_title">Row composable</string>
//<string name="third_description">A layout composable that places its children in a horizontal sequence.</string>
//<string name="fourth_title">Column composable</string>
//<string name="fourth_description">A layout composable that places its children in a vertical sequence.</string>