package com.softdevelopers.intro_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softdevelopers.intro_compose.ui.theme.Intro_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Intro_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Mycomponent(name: String, modifier: Modifier = Modifier){


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        //Adjuntamos al tamanio del contenedor
        modifier = Modifier
            .padding(20.dp)
            .background(color = Color.White)

    ){
        //Agregamos una imagen
        Image(painter = painterResource(id = R.drawable.iconcalendar), contentDescription = "Icon admin",
            Modifier
                .height(70.dp)
                .width(70.dp))
        Spacer(modifier = Modifier.height(15.dp))

        //Definimos el texto de bienvenida
        Text(text = "Bienvenido a compose $name", fontFamily = FontFamily.Monospace)


        //Ejemplo de un boton
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Haz click")

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
//Ejemplo1
@Composable
fun simpleLazyColum(){
    val itemList = listOf("Elemento1","Elemento2","Elemento3","Elemento4")

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(itemList){item ->
            Text(text = item, modifier = Modifier.padding(16.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

//Ejemplo2
@Composable
fun cardWithLazyColumn(){
    val personas = listOf("Persona1","Persona2","Persona3","Persona4")

    LazyColumn (modifier = Modifier.fillMaxSize()){
        items(personas){personas ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
            ){
                Column (modifier = Modifier.padding(16.dp)){
                    Text(text = personas, style =
                    MaterialTheme.typography.displayLarge)
                    Text(text = "Descripcion de la $personas")

                }
            }
        }

    }
}
//Ejercicio1
data class Contacto(val nombre: String, val numero: String, val email: String)

@Composable
fun ContactItem(contacto: Contacto) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono de usuario
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Contacto",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Información del contacto
        Column {
            Text(text = contacto.nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))

            // Número de teléfono con ícono
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "Teléfono")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = contacto.numero)
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Correo electrónico con ícono
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Correo")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = contacto.email)
            }
        }
    }
}

@Composable
fun ContactListBase() {
    val contacts = listOf(
        Contacto("Ana Trabajo", "8884555", "ana@yahoo.es"),
        Contacto("Juan Mecanico", "87784566", "marina@gmail.com"),
        Contacto("Mi amor", "7848488", "danapaola@yahoo.es"),
        Contacto("Mi amor2", "5788448", "griselda@gmail.com")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(contacts) { contacto ->
            ContactItem(contacto = contacto)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//Ejercicio 2
data class Producto(
    val sku: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Float,
    val stock: Int
)

@Composable
fun ProductListBase() {
    val productos = listOf(
        Producto(1, "Laptop", "Laptop con 16GB de RAM y 512GB SSD", 999.99f, 5),
        Producto(2, "Smartphone", "Smartphone de última generación con pantalla OLED", 799.99f, 0),
        Producto(3, "Auriculares", "Auriculares inalámbricos con cancelación de ruido", 199.99f, 15)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        productos.forEach { producto ->
            ProductCard(producto)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductCard(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier
                .background(LightGray)
                .padding(16.dp)
        ) {
            Text(
                text = producto.nombre,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = producto.descripcion,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Precio: $${producto.precio}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Stock: ${producto.stock}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Agregar al carrito */ },
                modifier = Modifier.fillMaxWidth(),
                enabled = producto.stock > 0,

            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrito",
                        tint = White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Agregar a mi carrito", color = White)
                }
            }
        }
    }
}

//Ejercicio3
data class VentasProducto(
    val nombre: String,
    val ventasPrimerTrimestre: Int,
    val ventasSegundoTrimestre: Int,
    val ventasTercerTrimestre: Int
)

// Función para obtener la tendencia entre dos trimestres
fun tendencia(ventasSegundoTrimestre: Int, ventasTercerTrimestre: Int): String {
    return when {
        ventasTercerTrimestre > ventasSegundoTrimestre -> "subió"
        ventasTercerTrimestre < ventasSegundoTrimestre -> "bajó"
        else -> "se mantuvo"
    }
}

@Composable
fun VentasProductoList() {
    // Lista de ventas de productos
    val productosConVentas = listOf(
        VentasProducto("Lácteos", 1200, 3000, 2000),
        VentasProducto("Bebidas", 1000, 1020, 1800),
        VentasProducto("Frutas", 2100, 1800, 2500),
        VentasProducto("Carnes", 5000, 5200, 4800)
    )

    // Mostrar la lista de productos con sus ventas
    Column(modifier = Modifier.padding(16.dp)) {
        productosConVentas.forEach { producto ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow, RoundedCornerShape(8.dp))
                    .padding(15.dp)
            ) {
                Column {
                    // Nombre del producto y ventas por trimestres
                    Text(text = "Producto: ${producto.nombre}", fontSize = 18.sp)
                    Text(text = "Ventas 1er Trimestre: ${producto.ventasPrimerTrimestre}")
                    Text(text = "Ventas 2do Trimestre: ${producto.ventasSegundoTrimestre}")
                    Text(text = "Ventas 3er Trimestre: ${producto.ventasTercerTrimestre}")

                    // Tendencia de ventas
                    val tendenciaText = tendencia(producto.ventasSegundoTrimestre, producto.ventasTercerTrimestre)

                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Tendencia: $tendenciaText", modifier = Modifier.weight(1f))
                        // Mostrar icono dependiendo de la tendencia
                        when (tendenciaText) {
                            "bajó" -> Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Bajó",
                                tint = Color.Red,
                                modifier = Modifier.size(48.dp)
                            )
                            "se mantuvo", "subió" -> Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Se mantuvo",
                                tint = Color.Green,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, device = Devices.PHONE)
@Composable
fun GreetingPreview() {
    Intro_ComposeTheme {
        //Greeting("Card")
        //Ejemplo1
        //ContactListBase()
        //Ejemplo2
        //ProductListBase()
        //Ejercicio3
        VentasProductoList()




    }
}