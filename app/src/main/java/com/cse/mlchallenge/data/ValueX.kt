package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ValueX(
    @SerializedName("id")
    val id: String?, // MLA1055
    @SerializedName("name")
    val name: String?, // Celulares y Smartphones
    @SerializedName("path_from_root")
    val pathFromRoot: List<PathFromRoot?>?
)