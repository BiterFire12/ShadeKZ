package kz.shadekz.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "ShadeKZ",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Теневая навигация по Казахстану",
                modifier = Modifier.padding(top = 8.dp)
            )

            Button(
                onClick = {
                    // Location functionality will be connected later.
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Определить местоположение")
            }
        }
    }
}