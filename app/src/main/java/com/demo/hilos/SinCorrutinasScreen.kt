package com.demo.hilos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
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
fun SinCorrutinasScreen(
    volver: () -> Unit
) {
    var cargando by remember {
        mutableStateOf(false)
    }

    var estadoCompra by remember {
        mutableStateOf("Esperando compra...")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFB74D).copy(alpha = 0.1f),
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
                Icons.Default.ErrorOutline,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFFF57C00)
            )

            Text(
                text = "Sin Corrutinas",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF57C00)
            )

            Text(
                text = "Uso incorrecto de Thread.sleep() en Compose",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            SharedSpacer()

            ProductoCard(
                nombre = "PlayStation 5",
                precio = "S/ 2,800.00"
            )

            SharedSpacer()

            StatusCard(
                estado = estadoCompra,
                cargando = cargando,
                color = Color(0xFFFFA726)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    cargando = true
                    estadoCompra = "Procesando compra..."
                    // Lógica original: Bloquea el hilo y rompe la animación del indicador
                    Thread.sleep(3000)
                    cargando = false
                    estadoCompra = "Compra realizada ✅"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Confirmar Compra", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            }

            BotonVolver(volver)
        }
    }
}