package com.softdevelopers.intro_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview(showBackground = true, showSystemUi = true, device = Devices.PHONE)
@Composable
fun GreetingPreview() {
    Intro_ComposeTheme {
        //Greeting("Android")
        //Invocar al objeto composable  que deseamos previsualizar
        Column {

            val listanombres= listOf("Juan","Mateo","Messi","penalti para el real madrid")
            for(item in listanombres){
                Mycomponent(item)
            }
        }

    }
}