package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ValueXX(
    @SerializedName("id")
    val id: String?, // 5-100
    @SerializedName("name")
    val name: String?, // Desde 5% OFF
    @SerializedName("results")
    val results: Int? // 1
)