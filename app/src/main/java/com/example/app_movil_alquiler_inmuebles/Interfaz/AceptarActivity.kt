package com.example.app_movil_alquiler_inmuebles.Interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_movil_alquiler_inmuebles.R

@Composable
fun FrmAceptar(NavegarLogin: () -> Unit){
    Column(modifier = Modifier
        .background(Color(0xFF174378))
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Box() {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = null,modifier = Modifier.size(250.dp),
                )
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Box() {
               Text(text = "INMUEBLES",
                   fontWeight = FontWeight.Bold,
                   fontSize = 30.sp,
                   color = Color.Yellow)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Box() {
            Text(text = "Somos una aplicación inmobiliaria, que, por medio de un interfaz intuitivo , servicial e íntegro, busca dar seguridad y sentido de pertenencia a través de arrendatarios a inquilinos.",
                Modifier.padding(35.dp),
                fontSize = 18.sp,
                color = Color.White)
        }
        Spacer(modifier = Modifier.padding(80.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Continuar   ",
                color = Color.Yellow,
            )
            Button(
                onClick = { NavegarLogin() }
                ,colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
                ,shape = RoundedCornerShape(80),
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp

                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))

            }

        }
    }
}