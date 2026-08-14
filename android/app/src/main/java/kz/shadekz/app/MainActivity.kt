package kz.shadekz.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kz.shadekz.app.location.AndroidLocationRepository
import kz.shadekz.app.ui.MainScreen

class MainActivity : ComponentActivity() {

    private lateinit var locationRepository: AndroidLocationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationRepository = AndroidLocationRepository(this)

        setContent {
            MainScreen(
                locationRepository = locationRepository
            )
        }
    }
}