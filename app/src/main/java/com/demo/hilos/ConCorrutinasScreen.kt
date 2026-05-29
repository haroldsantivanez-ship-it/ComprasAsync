package com.demo.hilos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ConCorrutinasScreen(
    volver: () -> Unit
) {

    val scope = rememberCoroutineScope()

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
            text = "Compra CON Corrutinas",
            style = MaterialTheme.typography.headlineMedium
        )

        SharedSpacer()

        ProductoCard(
            nombre = "MacBook Pro M4",
            precio = "S/ 8500"
        )

        SharedSpacer()

        Button(
            onClick = {

                scope.launch {

                    cargando = true

                    estadoCompra = "Procesando compra..."

                    delay(3000)

                    cargando = false

                    estadoCompra = "✅ Compra realizada"
                }
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