package com.demo.hilos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MenuOption(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val color: Color,
    val description: String
)

@Composable
fun HilosScreen() {
    var pantalla by remember { mutableStateOf("menu") }

    val options = listOf(
        MenuOption("Sin Hilos", "sin_hilos", Icons.Default.Block, Color(0xFFEF5350), "Bloqueo total del sistema"),
        MenuOption("Con Hilos", "con_hilos", Icons.Default.Cyclone, Color(0xFF42A5F5), "Ejecución paralela clásica"),
        MenuOption("Sin Corrutinas", "sin_corrutinas", Icons.Default.Warning, Color(0xFFFFA726), "Manejo ineficiente de UI"),
        MenuOption("Con Corrutinas", "con_corrutinas", Icons.Default.AutoAwesome, Color(0xFF66BB6A), "Optimización moderna")
    )

    when (pantalla) {
        "menu" -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
                                MaterialTheme.colorScheme.surface
                            )
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    
                    Surface(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(80.dp),
                        shadowElevation = 8.dp
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                Icons.Default.ShoppingBag,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = "Async Store",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.primary,
                        letterSpacing = 2.sp
                    )
                    
                    Text(
                        text = "Demo de Hilos y Corrutinas",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(options) { option ->
                            Card(
                                onClick = { pantalla = option.route },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp),
                                shape = RoundedCornerShape(24.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = option.color.copy(alpha = 0.15f)
                                ),
                                border = androidx.compose.foundation.BorderStroke(1.dp, option.color.copy(alpha = 0.3f))
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        option.icon,
                                        contentDescription = null,
                                        tint = option.color,
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text(
                                        text = option.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        color = option.color
                                    )
                                    Text(
                                        text = option.description,
                                        style = MaterialTheme.typography.labelSmall,
                                        textAlign = TextAlign.Center,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        "sin_hilos" -> SinHilosScreen { pantalla = "menu" }
        "con_hilos" -> ConHilosScreen { pantalla = "menu" }
        "sin_corrutinas" -> SinCorrutinasScreen { pantalla = "menu" }
        "con_corrutinas" -> ConCorrutinasScreen { pantalla = "menu" }
    }
}