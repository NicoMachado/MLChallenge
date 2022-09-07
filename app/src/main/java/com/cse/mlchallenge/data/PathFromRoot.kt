package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class PathFromRoot(
    @SerializedName("id")
    val id: String?, // MLA1051
    @SerializedName("name")
    val name: String? // Celulares y Teléfonos
)