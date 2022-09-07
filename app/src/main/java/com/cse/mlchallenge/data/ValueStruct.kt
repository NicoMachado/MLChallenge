package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ValueStruct(
    @SerializedName("number")
    val number: Double?, // 16.7
    @SerializedName("unit")
    val unit: String? // g
)