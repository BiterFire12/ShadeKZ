package kz.shadekz.app.privacy

/**
 * Central point for privacy-related application rules.
 *
 * No location data should be transmitted remotely
 * unless an explicit feature and privacy decision allows it.
 */
class PrivacyManager {

    fun shouldUploadPreciseLocation(): Boolean {
        return false
    }

    fun shouldStoreLocationHistory(): Boolean {
        return false
    }

    fun shouldEnableBackgroundLocation(): Boolean {
        return false
    }
}