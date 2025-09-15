package com.yhz.my_book_collection.data.remote

import com.yhz.my_book_collection.data.model.LoginResponse
import com.yhz.my_book_collection.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("auth/logout")
    suspend fun logout(): Response<Unit>
}
