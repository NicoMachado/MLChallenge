package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id")
    val id: String?, // AR
    @SerializedName("name")
    val name: String? // Argentina
)