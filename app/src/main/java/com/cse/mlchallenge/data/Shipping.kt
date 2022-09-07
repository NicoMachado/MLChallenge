package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("free_shipping")
    val freeShipping: Boolean?, // true
    @SerializedName("mode")
    val mode: String?, // me2
    @SerializedName("tags")
    val tags: List<String?>?,
    @SerializedName("logistic_type")
    val logisticType: String?, // cross_docking
    @SerializedName("store_pick_up")
    val storePickUp: Boolean? // false
)