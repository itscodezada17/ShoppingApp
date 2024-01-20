package com.ujjwal.sneakers.productsList.sources

import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.utilities.CONSTANTS
import retrofit2.Retrofit
import retrofit2.http.GET
import timber.log.Timber
import javax.inject.Inject


class ProductListRemoteRepo @Inject constructor(
    private var retrofit: Retrofit
){
    val service = retrofit.create(ApiRequest::class.java)

   suspend fun getProductsList(): Result<List<ProductItem>> {
        return try {
            val response = service.getProductsList()
            Result.success(response)
        } catch (e: Exception) {
            Timber.e(e.toString())
            Result.failure(e)
        }
    }

    interface ApiRequest {
        @GET(CONSTANTS.PRODUCT_LIST)
        suspend fun getProductsList(): List<ProductItem>
    }

}


