package com.ujjwal.sneakers.cart.source

import com.ujjwal.sneakers.cart.dataModel.CartResponseModel

interface CartDataSource {
    suspend fun getCartList(): Result<CartResponseModel>
}