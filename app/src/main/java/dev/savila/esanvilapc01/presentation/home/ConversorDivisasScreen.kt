package dev.savila.esanvilapc01.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
fun CurrencyConverterScreen(navController: NavHostController) {
    var amount by remember { mutableStateOf("") }
    var conversionType by remember { mutableStateOf("USD a PEN") }
    var convertedAmount by remember { mutableStateOf("") }

    val conversionRate = 3.80  // 1 USD = 3.80 PEN

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Monto a convertir:")
        TextField(value = amount, onValueChange = { amount = it })

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tipo de conversión:")
        DropdownMenu(
            expanded = true,
            onDismissRequest = { /* do nothing */ }
        ) {
            listOf("USD a PEN", "PEN a USD").forEach { conversion ->
                DropdownMenuItem(onClick = { conversionType = conversion }) {
                    Text(conversion)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val amountDouble = amount.toDoubleOrNull() ?: 0.0
            if (amountDouble > 0) {
                convertedAmount = if (conversionType == "USD a PEN") {
                    (amountDouble * conversionRate).toString()
                } else {
                    (amountDouble / conversionRate).toString()
                }
            }
        }) {
            Text("Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (convertedAmount.isNotEmpty()) {
            Text("Resultado: $convertedAmount")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("mainMenu") }) {
            Text("Regresar al Menú Principal")
        }
    }
}

fun DropdownMenuItem(onClick: () -> Unit, interactionSource: @Composable () -> Unit) {

}
