package com.example.projectandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: String,
    val Region: String
) : Parcelable
