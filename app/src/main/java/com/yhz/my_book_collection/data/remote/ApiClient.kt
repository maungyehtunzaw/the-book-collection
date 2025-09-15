package com.yhz.my_book_collection.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private const val BASE_URL = "https://your.api.base.url/" // TODO: Replace with your actual API base URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Use Level.NONE for release builds
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        // Add other interceptors if needed (e.g., for adding auth tokens)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }

    // We will add UserApiService here later
    // val userService: UserApiService by lazy {
    //     retrofit.create(UserApiService::class.java)
    // }
}
