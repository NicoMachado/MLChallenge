package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Excluded(
    @SerializedName("real_value")
    val realValue: Int?, // 0
    @SerializedName("real_rate")
    val realRate: Int? // 0
)