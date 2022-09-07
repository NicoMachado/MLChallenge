package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    @SerializedName("id")
    val id: String?, // MLA1117089595
    @SerializedName("site_id")
    val siteId: String?, // MLA
    @SerializedName("title")
    val title: String?, // Motorola Moto G6 Play 32 Gb Azul Bueno
    @SerializedName("seller")
    val seller: Seller?,
    @SerializedName("price")
    val price: Double?, // 32979.03
//    @SerializedName("prices")
//    val prices: Prices?,
    @SerializedName("sale_price")
    val salePrice: Double?, // null
    @SerializedName("currency_id")
    val currencyId: String?, // ARS
    @SerializedName("available_quantity")
    val availableQuantity: Int?, // 1
    @SerializedName("sold_quantity")
    val soldQuantity: Int?, // 4
    @SerializedName("buying_mode")
    val buyingMode: String?, // buy_it_now
    @SerializedName("listing_type_id")
    val listingTypeId: String?, // gold_special
    @SerializedName("stop_time")
    val stopTime: String?, // 2041-12-19T04:00:00.000Z
    @SerializedName("condition")
    val condition: String?, // new
    @SerializedName("permalink")
    val permalink: String?, // https://articulo.mercadolibre.com.ar/MLA-1117089595-motorola-moto-g6-play-32-gb-azul-bueno-_JM
    @SerializedName("thumbnail")
    val thumbnail: String?, // http://http2.mlstatic.com/D_818339-MLA48666151195_122021-O.jpg
    @SerializedName("thumbnail_id")
    val thumbnailId: String?, // 818339-MLA48666151195_122021
//    @SerializedName("accepts_mercadopago")
//    val acceptsMercadopago: Boolean?, // true
//    @SerializedName("installments")
//    val installments: Installments?,
//    @SerializedName("address")
//    val address: Address?,
//    @SerializedName("shipping")
//    val shipping: Shipping?,
//    @SerializedName("seller_address")
//    val sellerAddress: SellerAddress?,
    @SerializedName("attributes")
    val attributes: List<Attribute>?,
    @SerializedName("original_price")
    val originalPrice: Double?, // 33999
    @SerializedName("category_id")
    val categoryId: String?, // MLA1055
//    @SerializedName("official_store_id")
//    val officialStoreId: Any?, // null
//    @SerializedName("domain_id")
//    val domainId: String?, // MLA-CELLPHONES
//    @SerializedName("catalog_product_id")
//    val catalogProductId: String?, // MLA9413721
//    @SerializedName("tags")
//    val tags: List<String>?,
//    @SerializedName("order_backend")
//    val orderBackend: Int?, // 1
//    @SerializedName("use_thumbnail_id")
//    val useThumbnailId: Boolean?, // false
//    @SerializedName("offer_score")
//    val offerScore: Any?, // null
//    @SerializedName("offer_share")
//    val offerShare: Any?, // null
//    @SerializedName("match_score")
//    val matchScore: Any?, // null
//    @SerializedName("winner_item_id")
//    val winnerItemId: Any?, // null
//    @SerializedName("melicoin")
//    val melicoin: Any?, // null
//    @SerializedName("discounts")
//    val discounts: Any?, // null
//    @SerializedName("differential_pricing")
//    val differentialPricing: DifferentialPricing?
) : Serializable