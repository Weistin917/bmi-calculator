package com.example.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Weight (lb)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Height (cm)") },
            modifier = Modifier.fillMaxWidth()
        )

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