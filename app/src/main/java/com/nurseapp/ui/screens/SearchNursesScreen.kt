package com.nurseapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseapp.R

@Composable
fun SearchNursesScreen() {
    var searchText by remember { mutableStateOf("") }
    var searchedName by remember { mutableStateOf("") }

    val nurseNames = listOf(
        stringResource(R.string.buscar_enfermero_1),
        stringResource(R.string.buscar_enfermero_2),
        stringResource(R.string.buscar_enfermero_3)
    )
    val nurseIconDescription = stringResource(R.string.buscar_icono)

    val filteredNurses = if (searchedName.isBlank()) {
        nurseNames
    } else {
        nurseNames.filter { it.contains(searchedName, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_background))
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(R.string.buscar_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_dark)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.buscar_campo)) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.primary),
                unfocusedBorderColor = colorResource(R.color.text_secondary),
                focusedLabelColor = colorResource(R.color.primary),
                cursorColor = colorResource(R.color.primary)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.buscar_resultados),
            fontSize = 16.sp,
            color = colorResource(R.color.text_secondary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.weight(1f)) {
            if (filteredNurses.isEmpty()) {
                Text(
                    text = stringResource(R.string.buscar_sin_resultados),
                    fontSize = 16.sp,
                    color = colorResource(R.color.text_secondary)
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(filteredNurses) { nurse ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                                .background(
                                    color = colorResource(R.color.surface),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "👩‍⚕️",
                                modifier = Modifier.semantics {
                                    contentDescription = nurseIconDescription
                                },
                                fontSize = 32.sp
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = nurse,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(R.color.text_primary)
                            )
                        }
                    }
                }
            }
        }

        Button(
            onClick = { searchedName = searchText.trim() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.primary),
                contentColor = colorResource(R.color.white)
            )
        ) {
            Text(text = stringResource(R.string.buscar_boton))
        }
    }
}
