// Result display card
package com.example.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bmicalculator.R

/*
* Params:
* The result value.
* */
@Composable
fun ResultCard(
    result: Float
) {
    // Card color
    val cardClr = CardColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        disabledContainerColor = Color(33, 31, 26),
        disabledContentColor = Color(33, 31, 26)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        colors = cardClr
    ){
        // Checks the value of the result for the interpretation
        when {
            // Error state for incorrect input
            result == -1f ->
                ErrorContent(
                    message = "Entered values must be numeric.",
                    imageID = R.drawable.error
                )
            0 < result && result < 18.5f ->
                ResultContent(
                    color = Color.Cyan,
                    value = result,
                    message = "Underweight",
                    imageID = R.drawable.underweight
                )
            18.5f <= result && result < 25 ->
                ResultContent(
                    color = Color.Green,
                    value = result,
                    message = "Normal weight",
                    imageID = R.drawable.normal
                )
            25 <= result && result < 40 ->
                ResultContent(
                    color = Color.Yellow,
                    value = result,
                    message = "Overweight",
                    imageID = R.drawable.overweight
                )
            40 < result ->
                ResultContent(
                    color = Color.Red,
                    value = result,
                    message = "Obese",
                    imageID = R.drawable.obese
                )
            else -> {}
        }
    }
}

// Content for a correct result
/*
* Params:
* Circle color, result value, message to display and ID for the image to show.
* */
@Composable
fun ResultContent(
    color: Color,
    value: Float,
    message: String,
    imageID: Int
) {
    Row {
        Column(
            modifier = Modifier
                .background(Color(215, 244, 241))
                .fillMaxHeight()
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // A circle indicating the state of the result
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(shape = CircleShape)
                    .background(color)
            ) {}
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Your BMI is:", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "%.2f".format(null, value),
                style = MaterialTheme.typography.headlineLarge,
                color = Color(162, 133, 87)
            )
            Text(text = message, style = MaterialTheme.typography.bodyMedium)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            // Image to indicate the state of the result
            Image(
                painter = painterResource(id = imageID),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}

// Content to show when an error occurs.
/*
* Params:
* The message to show and ID of the image to show.
* */
@Composable
fun ErrorContent(
    message: String,
    imageID: Int
) {
    Row {
        Column(
            modifier = Modifier
                .background(Color(215, 244, 241))
                .fillMaxHeight()
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Error!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = message, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}