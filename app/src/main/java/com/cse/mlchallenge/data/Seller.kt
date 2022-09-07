package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Seller(
    @SerializedName("id")
    val id: Int?, // 212011454
    @SerializedName("permalink")
    val permalink: String?, // http://perfil.mercadolibre.com.ar/RIIING+TECNOLOGIAMOVIL
    @SerializedName("registration_date")
    val registrationDate: String?, // 2016-04-22T14:32:49.000-04:00
    @SerializedName("car_dealer")
    val carDealer: Boolean?, // false
    @SerializedName("real_estate_agency")
    val realEstateAgency: Boolean?, // false
    @SerializedName("tags")
    val tags: List<String>?,
//    @SerializedName("eshop")
//    val eshop: Eshop?,
//    @SerializedName("seller_reputation")
//    val sellerReputation: SellerReputation?
)