package com.ujjwal.sneakers.productsList.callBacks

import com.ujjwal.sneakers.productsList.ProductsListViewModel
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.productsList.ProductsListFragmentDirections
import timber.log.Timber

class ClickCallBacks constructor(
    private val productsListViewModel: ProductsListViewModel
) {

     fun navigateToProductDetailFragment(productId: String){
         val directions =
             ProductsListFragmentDirections.actionProductListFragmentToProductDetailFragment(productId)
         productsListViewModel.updateDirections(directions)
     }
    fun addToCart(productItem: ProductItem){
        // Add Item To cart
        productsListViewModel.addToCart(productItem.id.toString())
        Timber.e("Add To cart clicked")
    }

}