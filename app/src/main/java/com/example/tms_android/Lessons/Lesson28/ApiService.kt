package com.example.tms_android.Lessons.Lesson28

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @POST("carts")
    fun addToCart(@Body cart: Cart): Call<Cart>

    @DELETE("carts/{id}")
    fun deleteFromCart(@Path("id") id: Int): Call<Void>

    @PUT("products/{id}")
    fun updateProduct(@Path("id") id: Int, @Body product: Product): Call<Product>
}
