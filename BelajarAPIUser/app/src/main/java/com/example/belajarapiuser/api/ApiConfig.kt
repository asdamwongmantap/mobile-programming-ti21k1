package com.example.belajarapiuser.api

import com.example.belajarapiuser.api.services.UserServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val BASE_URL = "https://dummyjson.com/"

    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userService: UserServices by lazy{
        retrofit.create(UserServices::class.java)
    }

}