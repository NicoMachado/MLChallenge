package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Presentation(
    @SerializedName("display_currency")
    val displayCurrency: String? // ARS
)