package com.example.tuapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Parcelize nos permite enviar objetos entre actividades en android
@Parcelize
data class Driver(
    val driverNumber: Int,
    val fullName: String,
    val firstName: String,
    val lastName: String,
    val countryCode: String,
    val teamName: String,
    val teamColour: String,
    val headshotUrl: String
) : Parcelable
