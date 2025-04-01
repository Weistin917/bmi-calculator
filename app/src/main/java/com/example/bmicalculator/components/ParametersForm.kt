package com.example.bmicalculator.components

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ParametersForm() {

    val btnColor = ButtonColors(
        containerColor = Color(162, 133, 87),
        contentColor = Color.White,
        disabledContentColor = Color(33, 31, 26),
        disabledContainerColor = Color(33, 31, 26)
    )
    Column {
        Row( modifier = Modifier.fillMaxWidth() ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Weight ()") }
            )
            UnitSelect(listOf("lb", "kg"))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row( modifier = Modifier.fillMaxWidth() ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Height ()") }
            )
            UnitSelect(listOf("cm", "m"))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = btnColor
        ) {
            Text(text = "Calculate BMI")
        }
    }
}

@Composable
fun UnitSelect(
    options: List<String>
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Select dimensional unit")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {}
                )
            }
        }
    }
}