
package com.fede.recordatorios

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fede.recordatorios.ui.theme.RecordatoriosTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RecordatoriosTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        var recordatorio by remember { mutableStateOf("") }
                        val recordatorios = remember { mutableStateListOf<String>() }
                        Text(
                            text = "Mis Recordatorios",
                            fontSize = 28.sp
                        )
                        OutlinedTextField(
                            value = recordatorio,
                            onValueChange = { recordatorio = it },
                            label = { Text("Escribí un recordatorio") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Button(
                            onClick = {
                                if (validarTitulo(recordatorio)) {
                                    recordatorios.add(recordatorio.trim())
                                    recordatorio = ""
                                }
                            }
                        ) {
                            Text("Agregar recordatorio")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Recordatorios de ejemplo",
                            fontSize = 20.sp
                        )

                        recordatoriosSimulados.forEach { elemento ->
                            Text(text = "Título: ${elemento.titulo}")
                            Text(text = "Categoría: ${etiquetasCategorias[elemento.categoria]}")
                            Text(text = "Prioridad: ${elemento.prioridad}")
                            Text(text = "Estado: ${elemento.estado}")
                            HorizontalDivider()
                        }
                        recordatorios.forEach { elemento ->
                            Text(text = "• $elemento")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecordatoriosTheme {
        Greeting("Android")
    }
}
