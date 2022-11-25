package com.example.app_movil_alquiler_inmuebles.Interfaz


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_movil_alquiler_inmuebles.R

@Composable
fun FrmInicio(){
   Column(modifier =  Modifier.background(Color(0xFF174378))
       .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally){
       Box() {
           Image(painter = painterResource(id = R.drawable.logo),
               contentDescription = null,modifier = Modifier.size(250.dp),

           )
       }
   }
}