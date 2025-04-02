package com.example.bmicalculator.components

import kotlin.math.pow

fun calculateBMI(
    weight: String,
    height: String,
    weightUnit: String,
    heightUnit: String,
    setResult: (Float) -> Unit
) {
    val floatRegex = Regex("[1-9]\\d*(\\.\\d+)?")
    if (floatRegex.matches(weight) && floatRegex.matches(height)) {
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