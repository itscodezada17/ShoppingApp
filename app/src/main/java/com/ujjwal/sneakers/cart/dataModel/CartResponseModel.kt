package com.ujjwal.sneakers.cart.dataModel

import com.google.gson.annotations.SerializedName

data class CartResponseModel (
    @SerializedName("products")
    var products : ArrayList<Products> = arrayListOf()
)

data class Products(
    @SerializedName("productId")
    var productId : String? = null,
    @SerializedName("quantity")
    var quantity  : Int? = null
)