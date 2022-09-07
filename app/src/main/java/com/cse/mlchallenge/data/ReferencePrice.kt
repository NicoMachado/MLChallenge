package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ReferencePrice(
    @SerializedName("id")
    val id: String?, // 8
    @SerializedName("type")
    val type: String?, // min_standard
    @SerializedName("conditions")
    val conditions: ConditionsX?,
    @SerializedName("amount")
    val amount: Double?, // 27499.99
    @SerializedName("currency_id")
    val currencyId: String?, // ARS
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: String?, // DEFAULT
    @SerializedName("tags")
    val tags: List<Any>?,
    @SerializedName("last_updated")
    val lastUpdated: String? // 2022-06-13T14:20:56Z
)