package com.softdevelopers.intro_compose

data class Venta(
    val producto: String,
    val cantidad: Int,
    val precio: Double
)

val listaVentas = listOf(
    Venta("Producto A", 5, 12.50),
    Venta("Producto B", 3, 20.00),
    Venta("Producto C", 10, 5.75)
)

