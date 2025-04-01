package com.example.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ResultCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ){
        Row {
            Column(
                modifier = Modifier
                    .background(Color(215, 244, 241))
                    .fillMaxHeight()
                    .width(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .clip(shape = CircleShape)
                        .background(Color.Green)
                ) {}
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Your BMI is:", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "24.99",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(162, 133, 87)
                )
                Text(text = "Normal weight", style = MaterialTheme.typography.bodyMedium)
            }
            Column {

            }
        }
    }
}