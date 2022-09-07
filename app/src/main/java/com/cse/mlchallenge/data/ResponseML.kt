package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ResponseML(
    @SerializedName("site_id")
    val siteId: String?, // MLA
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String?, // GMT-03:00
    @SerializedName("query")
    val query: String?, // Motorola G6
    @SerializedName("paging")
    val paging: Paging?,
    @SerializedName("results")
    val results: List<Results>?,
//    @SerializedName("sort")
//    val sort: Sort?,
//    @SerializedName("available_sorts")
//    val availableSorts: List<AvailableSort>?,
//    @SerializedName("filters")
//    val filters: List<Filter>?,
//    @SerializedName("available_filters")
//    val availableFilters: List<AvailableFilter>?
)