package com.yhz.my_book_collection.data.model

data class User(
    val id: String,
    val username: String,
    val email: String,
    val profileImageUrl: String? = null // Optional
)
