package com.ujjwal.sneakers.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ujjwal.sneakers.cart.source.CartDataSource
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.productsDetails.sources.SneakerDetailRepo
import com.ujjwal.sneakers.utilities.SingleEvent
import com.ujjwal.sneakers.utilities.di.DispatcherModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    @DispatcherModule.MainDispatcher val coroutineDispatcher: CoroutineDispatcher,
    val cartRemoteRepo: CartDataSource,
    val sneakersDetailRemoteRepo: SneakerDetailRepo
): ViewModel() {

    private val _navDirection: MutableLiveData<SingleEvent<NavDirections>> = MutableLiveData()
    val navDirections: LiveData<SingleEvent<NavDirections>> = _navDirection

    private val _snackBarLiveData: MutableLiveData<String> = MutableLiveData()
    val snackBarLiveData: LiveData<String> = _snackBarLiveData

    private val _cartLiveData: MutableLiveData<List<ProductItem>> = MutableLiveData()
    val cartLiveData: LiveData<List<ProductItem>> = _cartLiveData




    init {
        getCartSneakersList()
    }

    private fun getCartSneakersList() {
        viewModelScope.launch(coroutineDispatcher) {
            val response = cartRemoteRepo.getCartList()
            response.onSuccess {
                val cartList = mutableListOf<ProductItem>()
                for(i in it.products){
                    i.productId?.let {id->
                        val res = sneakersDetailRemoteRepo.getProductDetail(id)
                        res.onSuccess { item->
                            cartList.add(item)
                        }
                        res.onFailure { ex->
                            Timber.d("$ex")
                        }
                    }
                }
                _cartLiveData.postValue(cartList)
            }
            response.onFailure {
                Timber.d("Failed in SneakersListViewModel $it")
            }
        }
    }

    fun updateDirections(directions: NavDirections){
        _navDirection.postValue(SingleEvent(directions))
    }

    fun removeFromCart(productItem: ProductItem){
        // will make an api call in actual
        // but here just removing the data from liveData
        val list = cartLiveData.value
        val newMutableList = mutableListOf<ProductItem>()
        list?.let {
            for(item in it){
                if(item != productItem )
                    newMutableList.add(item)
            }
        }
        _cartLiveData.postValue(newMutableList)
    }

    fun updateSnackBarMessage(message: String){
        _snackBarLiveData.postValue(message)
    }


}