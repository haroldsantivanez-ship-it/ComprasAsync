package com.demo.hilos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
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
fun SinHilosScreen(
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
                        Color(0xFFE57373).copy(alpha = 0.1f),
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
                Icons.Default.Block,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFFD32F2F)
            )

            Text(
                text = "Sin Hilos (Bloqueo)",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD32F2F)
            )

            Text(
                text = "El hilo principal se detiene por completo",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            SharedSpacer()

            ProductoCard(
                nombre = "Laptop Gamer ASUS",
                precio = "S/ 3,500.00"
            )

            SharedSpacer()

            StatusCard(
                estado = estadoCompra,
                color = Color(0xFFEF5350)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    estadoCompra = "Procesando compra..."
                    // Lógica original: Bloquea el Main Thread
                    Thread.sleep(3000)
                    estadoCompra = "Compra realizada ✅"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF5350)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Confirmar Compra", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            }

            BotonVolver(volver)
        }
    }
}