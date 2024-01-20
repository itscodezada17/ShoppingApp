package com.ujjwal.sneakers.productsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ujjwal.sneakers.commonDataModels.ProductItem
import com.ujjwal.sneakers.productsList.sources.ProductsDataSource
import com.ujjwal.sneakers.utilities.SingleEvent
import com.ujjwal.sneakers.utilities.di.DispatcherModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class ProductsListViewModel @Inject constructor(
    @DispatcherModule.IoDispatcher val coroutineDispatcher: CoroutineDispatcher,
    var repo: ProductsDataSource
): ViewModel() {
    private val _navDirection: MutableLiveData<SingleEvent<NavDirections>> = MutableLiveData()
    val navDirections: LiveData<SingleEvent<NavDirections>> = _navDirection

    private val _productsListLiveData: MutableLiveData<List<ProductItem>> = MutableLiveData()
    val productsListLiveData: LiveData<List<ProductItem>> = _productsListLiveData

    private val _addToCartLiveData: MutableLiveData<SingleEvent<Boolean>> = MutableLiveData()
    val addToCartLiveData: LiveData<SingleEvent<Boolean>> = _addToCartLiveData

    init {
        getTopSneakersList()
    }

    private fun getTopSneakersList() {
        viewModelScope.launch(coroutineDispatcher) {
            val response = repo.getProductsList()
            response.onSuccess {
                _productsListLiveData.postValue(it)
            }
            response.onFailure {
                Timber.d("Failed in SneakersListViewModel $it")
            }
        }
    }

    fun addToCart(id:String) {
        _addToCartLiveData.postValue(SingleEvent(true))
    }


    fun updateDirections(directions: NavDirections){
        _navDirection.postValue(SingleEvent(directions))
    }

}