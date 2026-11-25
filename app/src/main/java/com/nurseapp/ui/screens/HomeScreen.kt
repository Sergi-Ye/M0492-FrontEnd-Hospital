package com.nurseapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseapp.R

@Composable
fun HomeScreen(
    onLoginClick: () -> Unit,
    onNursesClick: () -> Unit,
    onSearchClick: () -> Unit
) {

    var clicks by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_background))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Icono principal
        Surface(
            modifier = Modifier.size(100.dp),
            shape = CircleShape,
            color = colorResource(R.color.primary)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "✚",
                    fontSize = 55.sp,
                    color = colorResource(R.color.white)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Titulo
        Text(
            text = stringResource(R.string.home_titulo),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_dark)
        )

        Text(
            text = stringResource(R.string.app_name),
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.home_bienvenida),
            fontSize = 17.sp,
            color = colorResource(R.color.text_primary)
        )

        Text(
            text = stringResource(R.string.home_descripcion),
            fontSize = 14.sp,
            color = colorResource(R.color.text_secondary)
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Boton Login
        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.ir_login))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Boton Listar enfermeros
        Button(
            onClick = onNursesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.ir_lista))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Boton Buscar enfermeros
        Button(
            onClick = onSearchClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.ir_busqueda))
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Interaccion mutableState
        TextButton(
            onClick = { clicks++ }
        ) {
            Text(
                text = stringResource(R.string.home_clicks, clicks),
                color = colorResource(R.color.primary)
            )
        }
    }
}
