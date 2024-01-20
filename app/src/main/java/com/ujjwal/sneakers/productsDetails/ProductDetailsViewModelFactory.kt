package com.ujjwal.sneakers.productsDetails
import dagger.assisted.AssistedFactory

@AssistedFactory
interface ProductDetailsViewModelFactory {
    fun create(productId: String): ProductDetailsViewModel
}

