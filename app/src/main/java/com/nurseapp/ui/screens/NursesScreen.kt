package com.nurseapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseapp.R

// Clase de datos: guarda la información de UN enfermero
data class Enfermero(val nombre: String, val especialidad: String)

@Composable
fun NurseListScreen(
    onBackClick: () -> Unit      // Lo que pasa al pulsar "Volver" (lo decide la navegación)
) {

    // 1. DATOS DE EJEMPLO (sin backend): una lista de enfermeros
    val enfermeros = listOf(
        Enfermero(
            stringResource(R.string.lista_enfermero_1_nombre),
            stringResource(R.string.lista_enfermero_1_especialidad)
        ),
        Enfermero(
            stringResource(R.string.lista_enfermero_2_nombre),
            stringResource(R.string.lista_enfermero_2_especialidad)
        ),
        Enfermero(
            stringResource(R.string.lista_enfermero_3_nombre),
            stringResource(R.string.lista_enfermero_3_especialidad)
        ),
        Enfermero(
            stringResource(R.string.lista_enfermero_4_nombre),
            stringResource(R.string.lista_enfermero_4_especialidad)
        )
    )

    // 2. ESTADO (mutableState): guarda el nombre del enfermero pulsado.
    //    "" significa que todavía no hay ninguno seleccionado.
    //    Si cambia, Compose vuelve a dibujar la pantalla solo.
    var seleccionado by remember { mutableStateOf("") }

    // 3. LA PANTALLA
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_background))
            .padding(24.dp)
    ) {

        // Título
        Text(
            text = stringResource(R.string.lista_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_dark)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Texto que cambia según el estado
        Text(
            text = if (seleccionado.isEmpty()) {
                stringResource(R.string.lista_ninguno)
            } else {
                stringResource(R.string.lista_seleccionado, seleccionado)
            },
            fontSize = 16.sp,
            color = colorResource(R.color.text_secondary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista: dibuja una FilaEnfermero por cada enfermero.
        // weight(1f) = ocupa todo el espacio libre y deja el botón abajo.
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(enfermeros) { enfermero ->
                FilaEnfermero(
                    enfermero = enfermero,
                    estaSeleccionado = enfermero.nombre == seleccionado,
                    onClick = { seleccionado = enfermero.nombre }  // cambia el estado
                )
            }
        }

        // Botón volver
        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.lista_volver))
        }
    }
}

// Una fila de la lista (un composable propio, más fácil de leer)
@Composable
fun FilaEnfermero(
    enfermero: Enfermero,
    estaSeleccionado: Boolean,
    onClick: () -> Unit
) {
    // Si está seleccionado se pinta con otro color
    val colorFondo = if (estaSeleccionado) {
        colorResource(R.color.accent)
    } else {
        colorResource(R.color.surface)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(colorFondo, RoundedCornerShape(12.dp))
            .clickable { onClick() }      // hace la fila "pulsable"
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de persona
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = colorResource(R.color.primary),
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Nombre y especialidad, uno encima del otro
        Column {
            Text(
                text = enfermero.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.text_primary)
            )
            Text(
                text = enfermero.especialidad,
                fontSize = 14.sp,
                color = colorResource(R.color.text_secondary)
            )
        }
    }
}

// Vista previa en Android Studio (pestaña Split)
@Preview(showBackground = true)
@Composable
fun NurseListPreview() {
    NurseListScreen(onBackClick = {})
}