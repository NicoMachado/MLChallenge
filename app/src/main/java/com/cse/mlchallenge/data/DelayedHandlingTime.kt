package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class DelayedHandlingTime(
    @SerializedName("period")
    val period: String?, // 60 days
    @SerializedName("rate")
    val rate: Double?, // 0.0261
    @SerializedName("value")
    val value: Int?, // 57
    @SerializedName("excluded")
    val excluded: ExcludedXX?
)