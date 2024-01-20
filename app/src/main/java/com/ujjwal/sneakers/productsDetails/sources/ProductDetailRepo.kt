package com.ujjwal.sneakers.productsDetails.sources

import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.utilities.CONSTANTS
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import timber.log.Timber
import javax.inject.Inject

class SneakerDetailRepo @Inject constructor(
      private var retrofit: Retrofit
) {
    val service = retrofit.create(ProductDetailsApiService::class.java)


    suspend fun getProductDetail(productId: String): Result<ProductItem> {
        return try {
            val response = service.getProductDetail(productId)
            Result.success(response)
        } catch (e: Exception) {
            Timber.e(e.toString())
            Result.failure(e)
        }
    }

}


interface ProductDetailsApiService {
//    @POST("add_to_cart")
//    suspend fun addToCart(id:String , selectedColor: String , selectedSize: String): Boolean

    @GET(CONSTANTS.PRODUCT_DETAIL)
    suspend fun getProductDetail(
        @Path(CONSTANTS.QUERY_PRODUCT_ID) productId: String
    ): ProductItem
}