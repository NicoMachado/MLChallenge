package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("id")
    val id: String?, // 7
    @SerializedName("type")
    val type: String?, // standard
    @SerializedName("amount")
    val amount: Double?, // 31619.07
    @SerializedName("regular_amount")
    val regularAmount: Double?, // 33999
    @SerializedName("currency_id")
    val currencyId: String?, // ARS
    @SerializedName("last_updated")
    val lastUpdated: String?, // 2022-06-13T14:20:55Z
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: String?, // DEFAULT
)