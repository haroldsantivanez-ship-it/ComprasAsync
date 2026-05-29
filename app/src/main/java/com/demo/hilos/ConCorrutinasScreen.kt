package com.demo.hilos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF81C784).copy(alpha = 0.1f),
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
                Icons.Default.Bolt,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFF43A047)
            )

            Text(
                text = "Con Corrutinas",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF43A047)
            )

            Text(
                text = "Suspensión eficiente: el hilo queda libre",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            SharedSpacer()

            ProductoCard(
                nombre = "MacBook Pro M4",
                precio = "S/ 8,500.00"
            )

            SharedSpacer()

            StatusCard(
                estado = estadoCompra,
                cargando = cargando,
                color = Color(0xFF66BB6A)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    scope.launch {
                        cargando = true
                        estadoCompra = "Procesando compra..."
                        delay(3000)
                        cargando = false
                        estadoCompra = "Compra realizada ✅"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF66BB6A)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Confirmar Compra", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            }

            BotonVolver(volver)
        }
    }
}