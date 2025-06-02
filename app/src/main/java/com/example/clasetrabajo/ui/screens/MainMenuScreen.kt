package com.example.clasetrabajo.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable

fun MainMenuScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(10.dp)
            .fillMaxSize(),//prueba
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Text("Home Screens")
        Button(
            onClick = {navController.navigate("homeScreen")}
        ){
            Text("Go to Home Screen")
        }
        Text("Test Screen")
        Button(
            onClick = {navController.navigate("testScreen")}
        )
        {
            Text("Go to Test Screen")
        }
        /*Button(
            onClick = {navController.navigate("amScreen")}
        )
        {
            Text("Go to App Screen")
        }*/
        Text("Components Screen")
        Button(
            onClick = {navController.navigate("componentsScreen")}
        )
        {
            Text("Go to Components Screen")
        }
        Text("Login Screen")
        Button(
            onClick = {navController.navigate("loginScreen")}
        )
        {
            Text("Go to Login Screen")
        }
        //apis
        Text("Api Screens")
        Button(
            onClick = {navController.navigate("camScreen")}
        )
        {
            Text("Go to Camera")
        }
        Button(
            onClick = {navController.navigate("calScreen")}
        )
        {
            Text("Go to Calendar")
        }
        Button(
            onClick = {navController.navigate("biometric_screen")}
        )
        {
            Text("Go to Biometric")
        }
    }
}