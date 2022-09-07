package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("id")
    val id: String?, // AR-X
    @SerializedName("name")
    val name: String? // Córdoba
)