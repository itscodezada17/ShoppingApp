package com.ujjwal.sneakers.productsDetails.clickCallBacks

import com.ujjwal.sneakers.productsDetails.ProductDetailsViewModel

class ProductDetailsCallBack constructor(
    val productDetailsViewModel: ProductDetailsViewModel
) {
     var selectedColor: String? = ""
     var selectedSize: String? = ""


    fun addToCart(id:String ){
        // In this case
        productDetailsViewModel.addToCart(id)
    }
    fun selectColor(){
        // send this selected color  when added to cart clicked with sneaker I'd
        // This should be coming from backend to show the availability of size and color
        // then we'll send back to the backend accordingly
        //selectedColor = color

    }
    fun selectSize(size: String){
        //send this selected color  when added to cart clicked with sneaker I'd
        selectedSize = size
    }
}