package com.yhz.my_book_collection.data.remote

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
