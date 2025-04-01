package com.example.bmicalculator

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator.ui.theme.BmiCalculatorAppTheme
import com.example.bmicalculator.components.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiCalculatorAppTheme {
                BmiCalculatorContent()
            }
        }
    }
}

@Composable
fun BmiCalculatorContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            val bannerColor = Color(123, 191, 118)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = bannerColor)
            ) {
                Text(
                    text = "BMI Calculator",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        item {
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ParametersForm()
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ResultCard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BmiCalculatorAppTheme {
        BmiCalculatorContent()
    }
}