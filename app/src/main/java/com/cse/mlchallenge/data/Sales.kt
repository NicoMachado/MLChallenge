package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Sales(
    @SerializedName("period")
    val period: String?, // 60 days
    @SerializedName("completed")
    val completed: Int? // 2168
)