package com.ujjwal.sneakers.cart.source

import com.ujjwal.sneakers.cart.dataModel.CartResponseModel
import com.ujjwal.sneakers.utilities.CONSTANTS
import retrofit2.Retrofit
import retrofit2.http.GET
import timber.log.Timber
import javax.inject.Inject

class CartRemoteRepo @Inject constructor(
    val repo: Retrofit
) : CartDataSource {

    val service = repo.create(CartInterface::class.java)



    override suspend fun getCartList(): Result<CartResponseModel> {
        return try {
            val response = service.getCartList()
            Result.success(response)
        } catch (e: Exception) {
            Timber.e(e.toString())
            Result.failure(e)
        }
    }


    interface CartInterface {
        @GET(CONSTANTS.PRODUCT_CART)
        suspend fun getCartList(): CartResponseModel
    }

}