package com.bangkit.composeapp.model

data class Product(
    val id: Long,
    val image: Int,
    val title: String,
    val price: Int,
    val author: String,
    val description: String,
)
