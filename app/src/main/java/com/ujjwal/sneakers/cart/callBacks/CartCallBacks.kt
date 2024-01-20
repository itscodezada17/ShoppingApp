package com.ujjwal.sneakers.cart.callBacks

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ujjwal.sneakers.cart.CartFragmentDirections
import com.ujjwal.sneakers.cart.CartViewModel
import com.ujjwal.sneakers.commonDataModels.ProductItem

class CartCallBacks constructor(
    private val cartViewModel: CartViewModel
) {
    fun navigateToPaymentFragment(){
        // navigateToPaymentFragment
        if (cartViewModel.cartLiveData.value?.size==0){
            cartViewModel.updateSnackBarMessage("No items in Cart. Please Add Some Items!")
        }
        else{
            val direction = CartFragmentDirections.actionCartFragmentToCheckOutFragment()
            cartViewModel.updateDirections(direction)
        }
    }
    fun removeFromCart(productItem: ProductItem){
        cartViewModel.removeFromCart(productItem)
    }
}