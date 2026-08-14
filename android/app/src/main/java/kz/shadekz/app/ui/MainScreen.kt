package kz.shadekz.app.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import kz.shadekz.app.location.LocationRepository

@Composable
fun MainScreen(
    locationRepository: LocationRepository
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var locationText by remember {
        mutableStateOf("Местоположение ещё не определено")
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->

            val granted =
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

            if (granted) {
                scope.launch {
                    val location =
                        locationRepository.getCurrentLocation()

                    locationText = if (location != null) {
                        "Широта: %.6f\nДолгота: %.6f".format(
                            location.latitude,
                            location.longitude
                        )
                    } else {
                        "Не удалось получить местоположение"
                    }
                }
            } else {
                locationText = "Доступ к местоположению запрещён"
            }
        }

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

            Text(
                text = locationText,
                modifier = Modifier.padding(top = 24.dp)
            )

            Button(
                onClick = {

                    val fineGranted =
                        ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED

                    val coarseGranted =
                        ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED

                    if (fineGranted || coarseGranted) {

                        scope.launch {
                            val location =
                                locationRepository.getCurrentLocation()

                            locationText = if (location != null) {
                                "Широта: %.6f\nДолгота: %.6f".format(
                                    location.latitude,
                                    location.longitude
                                )
                            } else {
                                "Не удалось получить местоположение"
                            }
                        }

                    } else {
                        permissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Определить местоположение")
            }
        }
    }
}