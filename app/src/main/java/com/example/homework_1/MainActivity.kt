package com.example.homework_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homework_1.ui.theme.ComfortaaFamaly
import com.example.homework_1.ui.theme.DelaGothicOneFamaly
import com.example.homework_1.ui.theme.HomeWork_1Theme
import com.example.homework_1.ui.theme.MyGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeWork_1Theme {
                GreetingPreview()
            }
        }
    }
}

@Composable
fun NewNoteText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(24.dp),
        text = "Новая запись",
        style = TextStyle(
            fontSize = 28.sp,
            color = Color.Black,
            fontFamily = DelaGothicOneFamaly()
        )
    )
}

@Composable
fun BoxForIcons(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        StrangeIcon(modifier = Modifier.align(Alignment.TopStart), icon = Icons.Default.Close)
        StrangeIcon(modifier = Modifier.align(Alignment.TopEnd), icon = Icons.Default.Done)
    }
}

@Composable
fun StrangeIcon(modifier: Modifier = Modifier, icon: ImageVector) {
    Icon(
        modifier = modifier
            .padding(24.dp)
            .size(34.dp), imageVector = icon, contentDescription = "Close icon"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputNoteTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp),
        value = text,
        shape = RoundedCornerShape(14.dp),
        onValueChange = { text = it },
        label = { Text("Введите запись") }
    )
}

@Composable
fun SaveButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            MyGreen
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)
    ) {
        Text(
            text = "Сохранить",
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = ComfortaaFamaly()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            NewNoteText()
            BoxForIcons()
            InputNoteTextField()
        }

        SaveButton(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
                .fillMaxWidth()
                .height(50.dp)
        )
    }
}