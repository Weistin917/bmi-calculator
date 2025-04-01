package com.example.bmicalculator

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.activity.*
import androidx.activity.compose.setContent
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

}