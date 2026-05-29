package com.demo.hilos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConHilosScreen(
    volver: () -> Unit
) {

    var estadoCompra by remember {
        mutableStateOf("Esperando compra...")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Compra CON Hilos",
            style = MaterialTheme.typography.headlineMedium
        )

        SharedSpacer()

        ProductoCard(
            nombre = "iPhone 15 Pro Max",
            precio = "S/ 5200"
        )

        SharedSpacer()

        Button(
            onClick = {

                estadoCompra = "Procesando compra..."

                Thread {

                    Thread.sleep(3000)

                    estadoCompra = "Compra realizada"

                }.start()
            }
        ) {
            Text("Comprar")
        }

        SharedSpacer()

        Text(estadoCompra)

        SharedSpacer()

        BotonVolver(volver)
    }
}