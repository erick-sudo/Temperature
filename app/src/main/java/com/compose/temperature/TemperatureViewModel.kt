package com.compose.temperature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.lang.Exception
import kotlin.math.roundToInt

class TemperatureViewModel : ViewModel() {

    var isFahrenheit by mutableStateOf(true)

    var result by mutableStateOf("")

    fun switchChange() {
        isFahrenheit = !isFahrenheit
    }

    fun convertTemp(temp: String) {
        result = try {
            val tempInt = temp.toInt()

            if(isFahrenheit) {
                "${((tempInt - 32) * 0.5556).roundToInt()} \u2103"
            } else {
                "${((tempInt * 1.8) + 32).roundToInt()} \u2109"
            }
        } catch (e: Exception) {
            "Invalid Entry"
        }
    }

}