package com.streafy.shiftrandomusers.feature.userdetails.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri

fun Context.dialPhoneNumber(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = "tel:$phoneNumber".toUri()
    }
    if (intent.resolveActivity(this.packageManager) != null) {
        this.startActivity(intent)
    }
}

fun Context.showOnMap(address: String) {
    val encodedAddress = Uri.encode(address)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = "geo:0,0?q=$encodedAddress".toUri()
    }
    if (intent.resolveActivity(this.packageManager) != null) {
        this.startActivity(intent)
    }
}

fun Context.showOnMap(latitude: String, longitude: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = "geo:$latitude,$longitude".toUri()
    }
    if (intent.resolveActivity(this.packageManager) != null) {
        this.startActivity(intent)
    }
}

fun Context.sendEmailTo(email: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = "mailto:".toUri()
        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    }

    if (intent.resolveActivity(this.packageManager) != null) {
        this.startActivity(intent)
    }
}