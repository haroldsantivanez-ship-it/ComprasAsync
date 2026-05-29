package com.demo.hilos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SinHilosScreen(
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
            text = "Compra SIN Hilos",
            style = MaterialTheme.typography.headlineMedium
        )

        SharedSpacer()

        ProductoCard(
            nombre = "Laptop Gamer ASUS",
            precio = "S/ 3500"
        )

        SharedSpacer()

        Button(
            onClick = {

                estadoCompra = "Procesando compra..."

                Thread.sleep(3000)

                estadoCompra = "Compra realizada"
            }
        ) {
            Text("Comprar")
        }

        SharedSpacer()

        Text(
            text = estadoCompra
        )

        SharedSpacer()

        BotonVolver(volver)
    }
}