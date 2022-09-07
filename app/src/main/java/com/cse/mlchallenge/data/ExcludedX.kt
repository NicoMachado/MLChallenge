package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ExcludedX(
    @SerializedName("real_value")
    val realValue: Int?, // 2
    @SerializedName("real_rate")
    val realRate: Int? // 0
)