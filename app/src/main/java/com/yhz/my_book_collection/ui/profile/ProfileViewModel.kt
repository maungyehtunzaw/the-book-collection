package com.yhz.my_book_collection.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _username = MutableLiveData<String>().apply {
        value = "Book Lover"
    }
    val username: LiveData<String> = _username

    private val _userEmail = MutableLiveData<String>().apply {
        value = "booklover@example.com"
    }
    val userEmail: LiveData<String> = _userEmail

    private val _booksRead = MutableLiveData<Int>().apply {
        value = 0
    }
    val booksRead: LiveData<Int> = _booksRead

    private val _favoriteBooks = MutableLiveData<Int>().apply {
        value = 0
    }
    val favoriteBooks: LiveData<Int> = _favoriteBooks

    fun updateProfile(username: String, email: String) {
        _username.value = username
        _userEmail.value = email
    }

    // TODO: Add methods to update reading statistics
}
