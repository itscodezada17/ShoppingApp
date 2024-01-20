package com.ujjwal.sneakers.productsList.di

import com.ujjwal.sneakers.productsList.sources.ProductsDataSource
import com.ujjwal.sneakers.productsList.sources.ProductDefaultRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class ProductListRepoModule {

    @Binds
    @ViewModelScoped
    abstract fun bindListRepo(repo: ProductDefaultRepo): ProductsDataSource

}