package com.example.unitconvertingtesting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterApp()
        }
    }
}

@Composable
fun UnitConverterApp() {
    var inputValue by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter value to convert") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = convertTemperature(inputValue.text.toDoubleOrNull() ?: 0.0)
        }) {
            Text("Convert Celsius to Fahrenheit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = convertLength(inputValue.text.toDoubleOrNull() ?: 0.0)
        }) {
            Text("Convert Meters to Feet")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $result")
    }
}

// Conversion Functions
fun convertTemperature(celsius: Double): String {
    val fahrenheit = (celsius * 9 / 5) + 32
    return "$fahrenheit °F"
}

fun convertLength(meters: Double): String {
    val feet = meters * 3.28084
    return "$feet ft"
}