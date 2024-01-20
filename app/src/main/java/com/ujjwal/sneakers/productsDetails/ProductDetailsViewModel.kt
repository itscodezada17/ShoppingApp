package com.ujjwal.sneakers.productsDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.productsDetails.sources.SneakerDetailRepo
import com.ujjwal.sneakers.utilities.SingleEvent
import com.ujjwal.sneakers.utilities.di.DispatcherModule
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber


class ProductDetailsViewModel @AssistedInject constructor(
    @DispatcherModule.MainDispatcher val coroutineDispatcher: CoroutineDispatcher,
    val sneakersDetailRemoteRepo: SneakerDetailRepo,
    @Assisted var productId: String
) : ViewModel() {
    private val _addToCartLiveData: MutableLiveData<SingleEvent<Boolean>> = MutableLiveData()
    val addToCartLiveData: LiveData<SingleEvent<Boolean>> = _addToCartLiveData

    private val _productDetailResponseModel: MutableLiveData<ProductItem> = MutableLiveData()
    val productDetailResponseModel: LiveData<ProductItem> = _productDetailResponseModel


    fun refreshData() {
        getProductDetails()
    }

    private fun getProductDetails() {
        viewModelScope.launch(coroutineDispatcher) {
            val response = sneakersDetailRemoteRepo.getProductDetail(productId)
            response.onSuccess {
                _productDetailResponseModel.postValue(it)
            }
            response.onFailure {
                Timber.d("Failed in SneakersListViewModel $it")
            }
        }
    }


    fun addToCart(id:String){
        _addToCartLiveData.postValue(SingleEvent(true))
        // Network call to post this data to backend using add to cart API

        // updateLoadingState(Loading.LOADING, null, isCourseDataNullOrEmpty())
    // viewModelScope.launch(coroutineDispatcher) {
//            val response = sneakersDetailRemoteRepo.addTocart(id,selectedColor,selectedSize)
//            response.onSuccess {
//                _addToCartLiveData.postValue(SingleEvent(it))
//            }
//            response.onFailure {
//                Timber.d("Failed in SneakersListViewModel $it")
//            }
    }


    companion object {
        fun provideFactory(
            factory: ProductDetailsViewModelFactory,
            productId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create(productId) as T
            }
        }
    }
}
