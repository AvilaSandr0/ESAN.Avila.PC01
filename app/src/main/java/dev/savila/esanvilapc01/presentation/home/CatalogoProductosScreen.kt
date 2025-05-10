package dev.savila.esanvilapc01.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

private val Int.image: ImageRequest
    get() {
        TODO("Not yet implemented")
    }
private val Int.price: String
    get() {
        TODO("Not yet implemented")
    }
private val Int.name: Any
    get() {
        TODO("Not yet implemented")
    }

@Composable
fun ProductCatalogScreen(navController: NavHostController) {
    val products = listOf(
        Product("Laptop", 1200.0, "Laptop", "https://link-to-image.com/laptop.jpg"),
        Product("Smartphone", 800.0, "Smartphone", "https://link-to-image.com/smartphone.jpg"),
        Product("Accesorio", 50.0, "Accesorio", "https://link-to-image.com/accessory.jpg")
    )

    var totalPrice by remember { mutableStateOf(0.0) }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(products) { product ->
            ProductCard(product)
            totalPrice += product.price
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text("Total acumulado: \$${"%.2f".format(totalPrice)}")

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { navController.navigate("mainMenu") }) {
        Text("Regresar al Menú Principal")
    }
}

private operator fun Number.plusAssign(price: Any) {
    TODO("Not yet implemented")
}

fun items(count: List<Product>, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}

@Composable
fun ProductCard(product: Int) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(product.name)
            Text("\$${product.price}")
            Image(painter = rememberImagePainter(product.image), contentDescription = product.name.toString())
        }
    }
}

fun Text(name: Any) {
}

data class Product(val name: String, val price: Double, val category: String, val image: String)
