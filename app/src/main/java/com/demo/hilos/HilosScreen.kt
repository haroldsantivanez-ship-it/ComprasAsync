package com.demo.hilos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HilosScreen() {

    var pantalla by remember {
        mutableStateOf("menu")
    }

    when (pantalla) {

        "menu" -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ComprasAsync",
                    style = MaterialTheme.typography.headlineMedium
                )

                SharedSpacer()

                Button(
                    onClick = { pantalla = "sin_hilos" }
                ) {
                    Text("Sin Hilos")
                }

                SharedSpacer()

                Button(
                    onClick = { pantalla = "con_hilos" }
                ) {
                    Text("Con Hilos")
                }

                SharedSpacer()

                Button(
                    onClick = { pantalla = "sin_corrutinas" }
                ) {
                    Text("Sin Corrutinas")
                }

                SharedSpacer()

                Button(
                    onClick = { pantalla = "con_corrutinas" }
                ) {
                    Text("Con Corrutinas")
                }
            }
        }

        "sin_hilos" -> {
            SinHilosScreen {
                pantalla = "menu"
            }
        }

        "con_hilos" -> {
            ConHilosScreen {
                pantalla = "menu"
            }
        }

        "sin_corrutinas" -> {
            SinCorrutinasScreen {
                pantalla = "menu"
            }
        }

        "con_corrutinas" -> {
            ConCorrutinasScreen {
                pantalla = "menu"
            }
        }
    }
}