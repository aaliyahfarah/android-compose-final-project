package com.bangkit.composeapp.di

import com.bangkit.composeapp.data.ProductRepository

object Injection {
    fun provideRepository(): ProductRepository {
        return ProductRepository.getInstance()
    }
}