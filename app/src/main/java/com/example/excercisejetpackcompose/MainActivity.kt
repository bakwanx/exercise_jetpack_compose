package com.example.excercisejetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.excercisejetpackcompose.ui.theme.ExcerciseJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExcerciseJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxComponent()
                }
            }
        }
    }
}
@Composable
fun BoxComponent(){
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Scaffold(
            bottomBar = { BottomNavigationComponent() }
        ) {
            TextViewComponent()
            EditTextComponent()
            ButtonComponent()
        }
    }
}

@Composable
fun TextViewComponent(){
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 10.dp),
        text = "Hai, Selamat Datang!",
        fontSize = 16.sp,
        color = Color.Black
    )
}

@Composable
fun EditTextComponent(){
    val textState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 45.dp)
            .fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(text = "Masukkan Nama") }
    )
}

@Composable
fun ButtonComponent(){
    val context = LocalContext.current

    Button(
        colors =  ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        onClick = {
            Toast.makeText(context, "Klik", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .padding(start = 26.dp, end = 16.dp, top = 116.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Tambah", color = Color.White)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) { }
    }
}

@Composable
fun BottomNavigationComponent(){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Beranda", "Favorit", "Profil")

    BottomNavigation(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEachIndexed{index, item ->
            BottomNavigationItem(
                label = { Text(text = item) },
                icon = {Icons.Filled.Home},
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExcerciseJetpackComposeTheme {
        BoxComponent()
    }
}