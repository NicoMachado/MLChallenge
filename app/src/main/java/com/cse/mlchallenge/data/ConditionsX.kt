package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class ConditionsX(
    @SerializedName("context_restrictions")
    val contextRestrictions: List<String?>?,
    @SerializedName("start_time")
    val startTime: String?, // 2022-06-28T04:13:18Z
    @SerializedName("end_time")
    val endTime: String?, // 2022-07-05T04:13:18Z
    @SerializedName("eligible")
    val eligible: Boolean? // true
)