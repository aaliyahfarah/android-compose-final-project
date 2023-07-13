package com.bangkit.composeapp.ui.screen.cart

import com.bangkit.composeapp.model.OrderProduct

data class CartState(
    val orderProduct: List<OrderProduct>,
    val totalPrice: Int
)