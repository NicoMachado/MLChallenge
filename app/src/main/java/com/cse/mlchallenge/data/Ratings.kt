package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("negative")
    val negative: Double?, // 0.05
    @SerializedName("neutral")
    val neutral: Double?, // 0.02
    @SerializedName("positive")
    val positive: Double? // 0.93
)