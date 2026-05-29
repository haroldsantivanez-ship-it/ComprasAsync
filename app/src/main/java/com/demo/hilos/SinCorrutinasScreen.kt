package com.demo.hilos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SinCorrutinasScreen(
    volver: () -> Unit
) {

    var cargando by remember {
        mutableStateOf(false)
    }

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
            text = "Compra SIN Corrutinas",
            style = MaterialTheme.typography.headlineMedium
        )

        SharedSpacer()

        ProductoCard(
            nombre = "PlayStation 5",
            precio = "S/ 2800"
        )

        SharedSpacer()

        Button(
            onClick = {

                cargando = true

                estadoCompra = "Procesando compra..."

                Thread.sleep(3000)

                cargando = false

                estadoCompra = "Compra realizada"
            }
        ) {
            Text("Comprar")
        }

        SharedSpacer()

        if (cargando) {
            CircularProgressIndicator()
        }

        SharedSpacer()

        Text(estadoCompra)

        SharedSpacer()

        BotonVolver(volver)
    }
}