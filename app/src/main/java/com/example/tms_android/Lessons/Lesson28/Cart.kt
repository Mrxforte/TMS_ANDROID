package com.example.tms_android.Lessons.Lesson28

data class Cart(
    val id: Int,
    val userId: Int,
    val date: String,
    val products: List<CartProduct>
)

data class CartProduct(
    val productId: Int,
    val quantity: Int
)
