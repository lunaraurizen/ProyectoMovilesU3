package com.example.app_movil_alquiler_inmuebles.Interfaz


import android.app.Activity
import android.app.Instrumentation
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_movil_alquiler_inmuebles.R
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.core.app.ActivityCompat.startActivityForResult
import coil.compose.AsyncImage
import com.example.app_movil_alquiler_inmuebles.MainActivity
import com.example.app_movil_alquiler_inmuebles.MainActivity.Companion.RC_SIGN_IN
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



@Composable
fun FrmLogin(NavegarInmueble:() -> Unit){
    val TAG = "DATO"
    val db = Firebase.firestore


    fun guardarMapa(usuario : String, celular: String, correo: String, clave : String, provincia : String) {

        val usuario = hashMapOf(
            "Usuario" to usuario,
            "Celular" to celular,
            "Correo" to correo,
            "Contraseña" to clave,
            "Provincia" to provincia
        )
        db.collection("Usuarios")
            .add(usuario)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Documento agregado con ID: ${documentReference.id}")
            }
            .addOnFailureListener { error ->
                Log.w(TAG, "Error al agregar el documento", error)

            }

    }

    val usuario = remember { mutableStateOf("") }
    val clave1 = remember { mutableStateOf("") }
    val clave2 = remember { mutableStateOf("") }
    val celular = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val provincia = remember { mutableStateOf("") }
    val hidden = remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .background(Color(0xFF174378))
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Box() {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = null,modifier = Modifier.size(250.dp),
            )
        }

        Box() {
            Text(text = "Registro",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Yellow)
        }


        Column( modifier = Modifier.padding(30.dp)){
            OutlinedTextField( modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
                value = usuario.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = {
                    usuario.value = it
                },
                label = {
                    Text(text = "Usuario",color = Color.White)

                }
            )
            OutlinedTextField( modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
                value = celular.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = {
                    celular.value = it
                },
                label = {
                    Text(text = "Celular",color = Color.White)

                }
            )
            OutlinedTextField( modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

                value = correo.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = {
                    correo.value = it
                },
                label = {
                    Text(text = "Correo",color = Color.White)

                }
            )
            OutlinedTextField( modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

                value = provincia.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = {
                    provincia.value = it
                },
                label = {
                    Text(text = "Provincia",color = Color.White)

                }
            )
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = clave1.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = { clave1.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                    )
                },
                label = { Text("Contraseña",color = Color.White) },
                singleLine = true,
                placeholder = { Text("Contraseña",color = Color.White) },
                visualTransformation = if (hidden.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (hidden.value)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Localized description for accessibility services
                    val description = if (hidden.value) "Hide password" else "Show password"

                    // Toggle button to hide or display password
                    IconButton(onClick = {hidden.value = !hidden.value}){
                        Icon(imageVector  = image, description)
                    }
                }
            )

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = clave2.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow,
                    unfocusedBorderColor = White),
                onValueChange = { clave2.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                    )
                },
                label = { Text("Re-Contraseña",color = Color.White) },
                singleLine = true,
                placeholder = { Text("Re-Contraseña",color = Color.White) },
                visualTransformation = if (hidden.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (hidden.value)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Localized description for accessibility services
                    val description = if (hidden.value) "Hide password" else "Show password"

                    // Toggle button to hide or display password
                    IconButton(onClick = {hidden.value = !hidden.value}){
                        Icon(imageVector  = image, description)
                    }
                }
            )
            Column( modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ){
                Row() {
                    Button(onClick = {
                       if   (clave1.value == clave2.value)
                       {

                           guardarMapa(usuario.value, celular.value, correo.value , clave1.value, provincia.value)
                       }
                                     }
                        ,colors = ButtonDefaults.buttonColors(backgroundColor = Yellow)
                        ,shape = RoundedCornerShape(25)) {
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("Registrar"
                            ,color = Color(0xFF174378))
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row() {
                    Button(onClick = { val mainActivity = MainActivity.instance
                        mainActivity.signIn() }
                        ,colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ,shape = RoundedCornerShape(25)) {
                        Image(painter = painterResource(id = R.drawable.google),
                            contentDescription = null,modifier = Modifier.size(35.dp))
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("Google"
                            ,color = Color.Gray)
                    }
                    Button(onClick = { NavegarInmueble()}) {
                        Text(text = "Inmuebles")
                    }
                }
            }
        }
    }

}







