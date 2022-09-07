package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Transactions(
    @SerializedName("canceled")
    val canceled: Int?, // 931
    @SerializedName("period")
    val period: String?, // historic
    @SerializedName("total")
    val total: Int?, // 8723
    @SerializedName("ratings")
    val ratings: Ratings?,
    @SerializedName("completed")
    val completed: Int? // 7792
)