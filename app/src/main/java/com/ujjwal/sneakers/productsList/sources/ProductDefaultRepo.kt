package com.ujjwal.sneakers.productsList.sources

import com.ujjwal.sneakers.commonDataModels.ProductItem
import javax.inject.Inject

class ProductDefaultRepo @Inject constructor(
    val remoteRepo: ProductListRemoteRepo
): ProductsDataSource {
    override suspend fun getProductsList(): Result<List<ProductItem>> {
        return remoteRepo.getProductsList()
    }
}