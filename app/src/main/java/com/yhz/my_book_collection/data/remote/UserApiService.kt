package com.yhz.my_book_collection.data.remote

import com.yhz.my_book_collection.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
// import retrofit2.http.PUT // Example for update
// import retrofit2.http.Body // Example for update

interface UserApiService {

    @GET("users/{userId}") // Replace with your actual endpoint
    suspend fun getUserProfile(
        @Path("userId") userId: String,
        @Header("Authorization") authToken: String // Assuming token-based auth for profile
    ): Response<User>

    // Example for an update profile endpoint:
    // @PUT("users/{userId}")
    // suspend fun updateUserProfile(
    //     @Path("userId") userId: String,
    //     @Header("Authorization") authToken: String,
    //     @Body userUpdateRequest: UserUpdateRequest // You would need to create UserUpdateRequest model
    // ): Response<User>
}
