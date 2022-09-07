package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Paging(
    @SerializedName("total")
    val total: Int?, // 273
    @SerializedName("primary_results")
    val primaryResults: Int?, // 273
    @SerializedName("offset")
    val offset: Int?, // 0
    @SerializedName("limit")
    val limit: Int? // 50
)