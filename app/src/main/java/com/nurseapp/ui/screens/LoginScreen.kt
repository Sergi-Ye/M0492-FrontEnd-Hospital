package com.nurseapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseapp.R

@Composable
fun LoginScreen(
    onBackClick: () -> Unit
) {

    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_background))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Icono
        Text(
            text = "👤",
            fontSize = 55.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Titulo
        Text(
            text = stringResource(R.string.login_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_dark)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Campo usuario
        TextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text(stringResource(R.string.login_usuario)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo contraseña
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text(stringResource(R.string.login_contrasena)) },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Boton de login
        Button(
            onClick = {
                mensaje = if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                    "correcto"
                } else {
                    "error"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.login_entrar))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Mensaje de validacion
        if (mensaje == "error") {
            Text(
                text = stringResource(R.string.login_error),
                color = colorResource(R.color.error)
            )
        }

        if (mensaje == "correcto") {
            Text(
                text = stringResource(R.string.login_correcto),
                color = colorResource(R.color.success)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Volver a Home
        TextButton(
            onClick = onBackClick
        ) {
            Text(stringResource(R.string.login_volver))
        }
    }
}