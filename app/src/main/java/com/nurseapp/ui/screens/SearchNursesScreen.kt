package com.nurseapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseapp.R

@Composable
fun SearchNursesScreen(onBackClick: () -> Unit) {

    var searchText by remember { mutableStateOf("") }
    var searchedName by remember { mutableStateOf("") }

    val nurses = listOf(
        stringResource(R.string.buscar_enfermero_1),
        stringResource(R.string.buscar_enfermero_2),
        stringResource(R.string.buscar_enfermero_3)
    )

    val results = nurses.filter {
        it.contains(searchedName, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.app_background))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            color = colorResource(R.color.primary)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "✚",
                    fontSize = 45.sp,
                    color = colorResource(R.color.white)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.buscar_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_dark)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(stringResource(R.string.buscar_campo)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { searchedName = searchText },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.buscar_boton))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.buscar_resultados),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary_dark),
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(10.dp))

        if (results.isEmpty()) {
            Text(
                text = stringResource(R.string.buscar_sin_resultados),
                color = colorResource(R.color.text_secondary)
            )
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(results) { nurse ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(R.color.surface)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = colorResource(R.color.primary),
                                modifier = Modifier.size(32.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = nurse,
                                fontSize = 16.sp,
                                color = colorResource(R.color.text_primary)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.buscar_volver),
                color = colorResource(R.color.primary)
            )
        }
    }
}