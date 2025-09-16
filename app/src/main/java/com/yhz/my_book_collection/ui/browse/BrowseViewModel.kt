package com.yhz.my_book_collection.ui.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrowseViewModel : ViewModel() {

    private val _books = MutableLiveData<List<Any>>().apply {
        value = emptyList()
    }
    val books: LiveData<List<Any>> = _books

    private val _sortOption = MutableLiveData<String>().apply {
        value = "title"
    }
    val sortOption: LiveData<String> = _sortOption

    private val _filterOptions = MutableLiveData<Map<String, String>>().apply {
        value = emptyMap()
    }
    val filterOptions: LiveData<Map<String, String>> = _filterOptions

    fun setSortOption(option: String) {
        _sortOption.value = option
        // TODO: Apply sorting
    }

    fun setFilterOptions(filters: Map<String, String>) {
        _filterOptions.value = filters
        // TODO: Apply filters
    }

    // TODO: Add methods to load and filter books
}
