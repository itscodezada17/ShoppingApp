package com.ujjwal.sneakers.commonDataModels

import com.google.gson.annotations.SerializedName


data class ProductItem (
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("image")
    var media: String?  = null,
    @SerializedName("price")
    var retailPrice: Float? = null,
    @SerializedName("category")
    var cateory: String? = null,
    @SerializedName("title")
    var name: String? = null,
    @SerializedName("description")
    var title: String? = null

): java.io.Serializable
