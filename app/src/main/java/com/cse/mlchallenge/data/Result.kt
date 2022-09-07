package com.cse.mlchallenge.data

import com.google.gson.annotations.SerializedName

data class Resultado(
    @SerializedName("fsq_id")
    val fsqId: String?, //
    @SerializedName("categories")
    val categories: List<String>?,
)
