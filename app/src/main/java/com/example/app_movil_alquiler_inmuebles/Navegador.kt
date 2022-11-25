package com.example.app_movil_alquiler_inmuebles

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_movil_alquiler_inmuebles.Interfaz.FrmAceptar
import com.example.app_movil_alquiler_inmuebles.Interfaz.FrmInicio
import com.example.app_movil_alquiler_inmuebles.Interfaz.FrmInmuebles
import com.example.app_movil_alquiler_inmuebles.Interfaz.FrmLogin

@Composable
fun NavegacionHost(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.aceptar.ruta) {
        composable(Rutas.aceptar.ruta){
            FrmAceptar (
                NavegarLogin = {
                    navController.navigate(Rutas.login.ruta)
                }
            )

        }
        composable(Rutas.login.ruta){
            FrmLogin (
                NavegarInmueble = {
                    navController.navigate(Rutas.inmuebles.ruta)
                }
            )
        }
        composable(Rutas.inmuebles.ruta){
            FrmInmuebles(

            )
        }

    }
}