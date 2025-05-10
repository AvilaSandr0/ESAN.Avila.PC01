package dev.savila.esanvilapc01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.savila.esanvilapc01.presentation.navigation.NavigationMenu
import dev.savila.esanvilapc01.ui.theme.ESANÁvilaPC01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ESANÁvilaPC01Theme {
                // Aquí configuramos el navController
                val navController = rememberNavController()

                // Llamamos a la función de navegación
                NavigationMenu(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ESANÁvilaPC01Theme {
        // Este es el estado que se previsualiza
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
