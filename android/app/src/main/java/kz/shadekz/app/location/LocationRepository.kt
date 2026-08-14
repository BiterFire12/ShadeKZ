package kz.shadekz.app.location

import android.location.Location

interface LocationRepository {

    suspend fun getCurrentLocation(): Location?
}