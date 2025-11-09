package com.example.laba4_geoquiz

import android.R.attr.enabled
import android.os.Bundle
import android.util.MutableFloat
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        val quiz = listOf(
            listOf("Canberra is the capital of Australia. ", true),
            listOf("The Pacific Ocean is larger than the Atlantic Ocean. ", true),
            listOf("The Suez Canal connects the Red Sea and the Indian Ocean.",false),
            listOf("The source of the Nile River is in Egypt.", false),
            listOf("The Amazon River is the longest river in the Americas.", true),
            listOf("Lake Baikal is the world's oldest and deepest freshwater lake.", true)
        )

        val quizcount = remember { mutableStateOf(0) }
        val goodanswer = remember { mutableStateOf(0) }
        var flag = true
        val enabled = remember { mutableStateOf(true) }
        val enablednext = remember { mutableStateOf(true) }
        val openDialog = remember { mutableStateOf(false) }
        if (quizcount.value == quiz.size-1) {
            enablednext.value=false
        }

        Row(shapeModifier.fillMaxWidth().height(75.dp).padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "GeoQuiz", fontSize = 30.sp, color = Color(0xffffffff))
        }
        Row (modifier.fillMaxWidth().padding(25.dp), horizontalArrangement = Arrangement.Center){
            Text("${quiz[quizcount.value][0]}", fontSize = 18.sp, color = Color(0xff7e7e7e))
        }
        Row (modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {val flag = true
                            if (flag == quiz[quizcount.value][1]){
                            goodanswer.value++}
                            enabled.value = false
                if (quizcount.value == quiz.size-1) {
                    openDialog.value=true
                }

            }, enabled = enabled.value,
                shape = RoundedCornerShape(10.dp),
                ) { Text("True", fontSize = 20.sp)}
            Button(onClick = {val flag = false
                if (flag == quiz[quizcount.value][1]){
                    goodanswer.value++}
                if (quizcount.value == quiz.size-1) {
                    openDialog.value=true
                }
                enabled.value = false}, enabled = enabled.value,
                shape = RoundedCornerShape(10.dp)) { Text("False", fontSize = 20.sp)}
        }
        Row(modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.End){
            Button(onClick ={

                    quizcount.value++
                    enabled.value = true
                
                enabled.value = true},enabled = enablednext.value, shape = RoundedCornerShape(10.dp)) {
                Text(text = "Next >", fontSize = 20.sp)
            }
        }



        if(quizcount.value == quiz.size){
            openDialog.value=true
        }
        if(openDialog.value){
            AlertDialog(
                onDismissRequest = {},
                title = { Text(text = "Викторина пройдена!") },
                text = { Text(text="Количество правильных ответов: ${goodanswer.value}/6", color = Color(0xff7e7e7e))},
                confirmButton = {
                    Button({
                        openDialog.value = false
                        quizcount.value = 0
                        goodanswer.value = 0
                        flag = true
                        enabled.value = true
                        enablednext.value = true
                        openDialog.value = false

                    }) {
                        Text("Пройти заново", fontSize = 22.sp)
                    }
                }
            )
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