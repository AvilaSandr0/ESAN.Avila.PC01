package dev.savila.esanvilapc01.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun DogAgeCalculatorScreen(navController: NavHostController) {
    var dogAge by remember { mutableStateOf("") }
    var dogSize by remember { mutableStateOf("Pequeño") }
    var dogAgeInDogYears by remember { mutableStateOf("") }

    val sizeOptions = listOf("Pequeño", "Mediano", "Grande")

    Column {
        Text("Ingrese la edad del perro (en años humanos):")
        TextField(value = dogAge, onValueChange = { dogAge = it })

        Spacer(modifier = Modifier.height(16.dp))

        Text("Seleccionar tamaño del perro:")
        // Aquí iría un Dropdown para seleccionar el tamaño

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val age = dogAge.toIntOrNull() ?: 0
            if (age > 0) {
                dogAgeInDogYears = when (dogSize) {
                    "Pequeño" -> (age * 5).toString()
                    "Mediano" -> (age * 6).toString()
                    "Grande" -> (age * 7).toString()
                    else -> "0"
                }
            }
        }) {
            Text("Calcular Edad en Años Perro")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (dogAgeInDogYears.isNotEmpty()) {
            Text("La edad de tu perro en años perro es: $dogAgeInDogYears años.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("mainMenu") }) {
            Text("Regresar al Menú Principal")
        }
    }
}
