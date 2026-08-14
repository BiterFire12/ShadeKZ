package kz.shadekz.app.location

import android.location.Location

/**
 * Provides the current location to the application.
 *
 * Important privacy rule:
 * this repository must not upload or persist
 * precise coordinates by itself.
 */
interface LocationRepository {

    suspend fun getCurrentLocation(): Location?
}