package com.ujjwal.sneakers.cart.di

import com.ujjwal.sneakers.cart.source.CartDataSource
import com.ujjwal.sneakers.cart.source.CartRemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CartModule {

    @Singleton
    @Provides
    fun bindListRepo(repo: Retrofit): CartDataSource {
        return CartRemoteRepo(repo)
    }

}