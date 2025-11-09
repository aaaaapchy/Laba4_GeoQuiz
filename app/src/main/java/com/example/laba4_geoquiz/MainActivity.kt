package com.example.laba4_geoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laba4_geoquiz.ui.theme.Laba4_GeoQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF6200EE),
                    background = Color.White,
                    surface = Color.White
                )
            ){
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),

                    content = { innerPadding ->
                        MainScreen(modifier = Modifier.padding(innerPadding))
                    }
                )
            }

        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val shapeModifier = Modifier
        .background(color = Color(0xFF6200EE))
    Column(modifier) {
        val quiz = listOf<String>("")
        Row(shapeModifier.fillMaxWidth().height(75.dp).padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "GeoQuiz", fontSize = 30.sp, color = Color(0xffffffff))
        }
        Row (modifier.fillMaxWidth().padding(25.dp), horizontalArrangement = Arrangement.Center){
            Text("Вопрос", fontSize = 18.sp, color = Color(0xff7e7e7e))
        }
        Row (modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {},
                shape = RoundedCornerShape(10.dp),
                ) { Text("True", fontSize = 20.sp)}
            Button(onClick = {},
                shape = RoundedCornerShape(10.dp)) { Text("False", fontSize = 20.sp)}
        }
        Row(modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.End){
            Button(onClick ={}, shape = RoundedCornerShape(10.dp)) {
                Text(text = "Next >", fontSize = 20.sp)
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Laba4_GeoQuizTheme {
        MainScreen()
    }
}