// Parameters Form
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

/*
* Params:
* Values for the entered weight and height, and its respective dimensional units.
* Functions to call on when any of the states change.
* Function to calculate the BMI.
* */
@Composable
fun ParametersForm(
    inputWeight: String,
    inputHeight: String,
    weightUnit: String,
    heightUnit: String,
    onWeightChange: (String) -> Unit,
    onHeightChange: (String) -> Unit,
    setWeightUnit: (String) -> Unit,
    setHeightUnit: (String) -> Unit,
    onCalculate: () -> Unit
) {
    // color for the button
    val btnColor = ButtonColors(
        containerColor = Color(162, 133, 87),
        contentColor = Color.White,
        disabledContentColor = Color(33, 31, 26),
        disabledContainerColor = Color(33, 31, 26)
    )
    Column {
        // Input fields with dimensional unit selector for each parameter
        Row( modifier = Modifier.fillMaxWidth() ) {
            OutlinedTextField(
                value = inputWeight,
                onValueChange = { onWeightChange(it) },
                label = { Text(text = "Weight ($weightUnit)") }
            )
            // Selector of dimensional unit
            UnitSelect(listOf("lb", "kg"), setWeightUnit)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row( modifier = Modifier.fillMaxWidth() ) {
            OutlinedTextField(
                value = inputHeight,
                onValueChange = { onHeightChange(it) },
                label = { Text(text = "Height ($heightUnit)") }
            )
            // Selector of dimensional unit
            UnitSelect(listOf("cm", "m"), setHeightUnit)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calculate button
        Button(
            onClick = onCalculate,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = btnColor
        ) {
            Text(text = "Calculate BMI")
        }
    }
}

// A dropdown select for the dimensional unit
@Composable
fun UnitSelect(
    options: List<String>,
    setUnit: (String) -> Unit
) {
    // State that manages the expansion of the select.
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
                    onClick = {
                        setUnit(option)
                        expanded = false
                    }
                )
            }
        }
    }
}