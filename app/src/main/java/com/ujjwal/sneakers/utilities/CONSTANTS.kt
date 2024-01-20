package com.ujjwal.sneakers.utilities

class CONSTANTS {
    companion object{
        private const val FAKE_API_BASE_URL = "https://fakestoreapi.com/"

        const val PRODUCT_LIST = FAKE_API_BASE_URL +  "products"

        const val PRODUCT_DETAIL = "${PRODUCT_LIST}/{product_id}"

        const val PRODUCT_CART = FAKE_API_BASE_URL +  "carts/1"


        const val QUERY_PRODUCT_ID = "product_id"
    }
}