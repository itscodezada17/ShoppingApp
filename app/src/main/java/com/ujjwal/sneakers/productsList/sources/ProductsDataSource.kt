package com.ujjwal.sneakers.productsList.sources

import com.ujjwal.sneakers.commonDataModels.ProductItem

interface ProductsDataSource {
    suspend fun getProductsList(): Result<List<ProductItem>>
}
