package com.yhz.my_book_collection.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {

    private val _categories = MutableLiveData<List<Any>>().apply {
        value = emptyList()
    }
    val categories: LiveData<List<Any>> = _categories

    private val _searchQuery = MutableLiveData<String>().apply {
        value = ""
    }
    val searchQuery: LiveData<String> = _searchQuery

    fun searchCategories(query: String) {
        _searchQuery.value = query
        // TODO: Implement search logic
    }

    // TODO: Add methods to add, edit, delete categories
}
