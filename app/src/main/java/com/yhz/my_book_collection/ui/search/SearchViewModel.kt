package com.yhz.my_book_collection.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _searchResults = MutableLiveData<List<Any>>().apply {
        value = emptyList()
    }
    val searchResults: LiveData<List<Any>> = _searchResults

    private val _searchQuery = MutableLiveData<String>().apply {
        value = ""
    }
    val searchQuery: LiveData<String> = _searchQuery

    private val _searchFilter = MutableLiveData<String>().apply {
        value = "all"
    }
    val searchFilter: LiveData<String> = _searchFilter

    fun search(query: String) {
        _searchQuery.value = query
        // TODO: Implement search logic
    }

    fun setSearchFilter(filter: String) {
        _searchFilter.value = filter
        // TODO: Apply filter to current search
    }

    // TODO: Add methods to perform search across books, authors, categories
}
