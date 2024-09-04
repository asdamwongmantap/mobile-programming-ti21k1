package com.example.belajarapiuser.api.services

import com.example.belajarapiuser.api.model.UsersResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserServices {
    @GET("users")
    fun getAll(): Call<UsersResponse>
}