package com.demo.hilos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SharedSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ProductoCard(
    nombre: String,
    precio: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = nombre,
                style = MaterialTheme.typography.titleLarge
            )

            SharedSpacer()

            Text(
                text = precio,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun BotonVolver(
    volver: () -> Unit
) {

    Button(
        onClick = volver
    ) {
        Text("Volver")
    }
}