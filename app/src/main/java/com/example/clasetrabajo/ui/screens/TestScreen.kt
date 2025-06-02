package com.example.clasetrabajo.ui.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.clasetrabajo.ComposeMultiScreenApp
import com.example.clasetrabajo.R
import com.example.clasetrabajo.ui.theme.ClaseTrabajoTheme

@Composable
fun TestScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text("Test Screen")
        Button(
            onClick = {navController.navigate("mainMenu")}

        ){
            Text("Return to Main Menu")
        }

        Button(
            onClick = {navController.navigate("testScreen")}
        ){
            Text("Go to Text Screen")
        }
        Column {
            Column {
                TextComposable()
                TextComposable()
                TextComposable()
            }
            Row {
                TextComposable()
                TextComposable()
                TextComposable()
            }
            Column {
                ModifierExample2()
            }
        }

        Column {
            ModifierExample4()
            CustomText()
            Picture()
        }
    }

}
@Composable
fun TextComposable(name:String = "Empty"){
    Text(text = "Hello world")
    Text(name)
}

@Preview(showBackground = true)
@Composable
fun ModifierExample1(){
    Column(
        modifier = Modifier
            .padding(40.dp, 30.dp, 20.dp, 10.dp)
    ){
        Text("Hello World")
    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text("Hello World")
    }
}
fun clickAction(){
    println("Column clicked")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Yellow)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextComposable("1")
        TextComposable("2")
        TextComposable("3")
        TextComposable("4")
        TextComposable("5")
        TextComposable("6")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample4(){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ){
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopEnd))
        Text("4", Modifier.align(Alignment.CenterStart))
        Text("5", Modifier.align(Alignment.Center))
        Text("6", Modifier.align(Alignment.CenterEnd))
        Text("7", Modifier.align(Alignment.BottomStart))
        Text("8", Modifier.align(Alignment.BottomCenter))
        Text("9", Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column(){
        Text(
            stringResource(R.string.Example_text),
            color = colorResource(R.color.teal_700),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )

        val gradientColors = listOf(Color.Blue, Color.Green, Color.Cyan, colorResource(R.color.purple_200))
        Text(
            stringResource(R.string.Example_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(300.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.satosugu),
            contentDescription = "Imagen satosugu"
        )
    }
}
