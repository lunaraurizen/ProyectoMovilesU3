package com.example.app_movil_alquiler_inmuebles

sealed class Rutas(
    val ruta: String
){
    object  inicio: Rutas("Inicio")
    object  login: Rutas("Login")
    object  aceptar: Rutas("Aceptar")
    object  inmuebles: Rutas("Inmuebles")
    object  detalle: Rutas("Detalle")

}