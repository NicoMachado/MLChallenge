package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Prices(
    @SerializedName("id")
    val id: String?, // MLA1117089595
    @SerializedName("prices")
    val prices: List<Price>?,
    @SerializedName("presentation")
    val presentation: Presentation?,
    @SerializedName("payment_method_prices")
    val paymentMethodPrices: List<Any>?,
    @SerializedName("reference_prices")
    val referencePrices: List<ReferencePrice>?,
    @SerializedName("purchase_discounts")
    val purchaseDiscounts: List<Any>?
)