package com.compose.temperature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.temperature.ui.theme.TemperatureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel: TemperatureViewModel = viewModel()

                    TemperatureConverter(
                        isFahrenheit = viewModel.isFahrenheit,
                        result = viewModel.result,
                        convertTemp = { viewModel.convertTemp(it) },
                        switchChange = { viewModel.switchChange() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TemperatureConverterPreview(
    viewModel: TemperatureViewModel = viewModel()
) {
    TemperatureTheme {
        TemperatureConverter(
            isFahrenheit = viewModel.isFahrenheit,
            result = viewModel.result,
            convertTemp = { viewModel.convertTemp(it) },
            switchChange = { viewModel.switchChange() }
        )
    }
}