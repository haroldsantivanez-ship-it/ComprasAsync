package com.demo.hilos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cyclone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConHilosScreen(
    volver: () -> Unit
) {
    var estadoCompra by remember {
        mutableStateOf("Esperando compra...")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF64B5F6).copy(alpha = 0.1f),
                        MaterialTheme.colorScheme.surface
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Icon(
                Icons.Default.Cyclone,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFF1E88E5)
            )

            Text(
                text = "Hilo Secundario",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E88E5)
            )

            Text(
                text = "La UI permanece fluida mientras se procesa",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            SharedSpacer()

            ProductoCard(
                nombre = "iPhone 15 Pro Max",
                precio = "S/ 5,200.00"
            )

            SharedSpacer()

            StatusCard(
                estado = estadoCompra,
                color = Color(0xFF42A5F5)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    estadoCompra = "Procesando compra..."
                    Thread {
                        Thread.sleep(3000)
                        estadoCompra = "Compra realizada ✅"
                    }.start()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF42A5F5)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Confirmar Compra", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            }

            BotonVolver(volver)
        }
    }
}