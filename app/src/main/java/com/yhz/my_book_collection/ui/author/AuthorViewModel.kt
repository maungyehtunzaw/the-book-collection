package com.yhz.my_book_collection.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorViewModel : ViewModel() {

    private val _authors = MutableLiveData<List<Any>>().apply {
        value = emptyList()
    }
    val authors: LiveData<List<Any>> = _authors

    private val _searchQuery = MutableLiveData<String>().apply {
        value = ""
    }
    val searchQuery: LiveData<String> = _searchQuery

    fun searchAuthors(query: String) {
        _searchQuery.value = query
        // TODO: Implement search logic
    }

    // TODO: Add methods to load authors and their books
}
