package dev.savila.esanvilapc01.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.savila.esanvilapc01.presentation.home.CurrencyConverterScreen
import dev.savila.esanvilapc01.presentation.home.DogAgeCalculatorScreen
import dev.savila.esanvilapc01.presentation.home.ProductCatalogScreen
import dev.savila.esanvilapc01.presentation.home.Text

@Composable
fun NavigationMenu(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "mainMenu") {
        // Pantalla principal de navegación
        composable("mainMenu") {
            MainMenuScreen(navController)
        }

        // Pantalla Calculadora de Edad Canina
        composable("dogAgeCalculator") {
            DogAgeCalculatorScreen(navController)
        }

        // Pantalla Conversor de Divisas
        composable("currencyConverter") {
            CurrencyConverterScreen(navController)
        }

        // Pantalla Catálogo de Productos Tecnológicos
        composable("productCatalog") {
            ProductCatalogScreen(navController)
        }
    }
}

@Composable
fun MainMenuScreen(navController: NavHostController) {
    // Aquí implementamos los botones del menú
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("dogAgeCalculator") }) {
            Text("Calculadora de Edad Canina")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("currencyConverter") }) {
            Text("Conversor de Divisas")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("productCatalog") }) {
            Text("Catálogo de Productos Tecnológicos")
        }
    }
}