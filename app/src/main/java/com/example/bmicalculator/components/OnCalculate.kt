package com.example.bmicalculator.components

import kotlin.math.pow

// function to calculate BMI
fun calculateBMI(
    weight: String,
    height: String,
    weightUnit: String,
    heightUnit: String,
    setResult: (Float) -> Unit
) {
    // Checks if the input is numeric, if not, sets the result in an error state (-1)
    val floatRegex = Regex("[1-9]\\d*(\\.\\d+)?")
    if (floatRegex.matches(weight) && floatRegex.matches(height)) {
        // makes necessary conversions; the calc is done in kg and m.
        val h = if (heightUnit == "cm") height.toFloat() / 100 else height.toFloat()
        val w = when (weightUnit) {
            "lb" -> weight.toFloat() / 2.205f
            "kg" -> weight.toFloat()
            else -> 0f
        }
        setResult((w / h.pow(2)))
    } else {
        setResult(-1f)
    }
}