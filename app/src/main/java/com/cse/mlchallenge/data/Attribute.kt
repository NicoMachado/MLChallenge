package com.cse.mlchallenge.data


import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("id")
    val id: String?, // BRAND
    @SerializedName("name")
    val name: String?, // Marca
    @SerializedName("value_id")
    val valueId: String?, // 2503
    @SerializedName("attribute_group_id")
    val attributeGroupId: String?, // OTHERS
    @SerializedName("attribute_group_name")
    val attributeGroupName: String?, // Otros
    @SerializedName("source")
    val source: Long?, // 4954751883138633
    @SerializedName("value_name")
    val valueName: String?, // Motorola
    @SerializedName("value_struct")
    val valueStruct: ValueStruct?,
    @SerializedName("values")
    val values: List<Value?>?
)