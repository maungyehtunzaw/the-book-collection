package com.yhz.my_book_collection.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _totalBooks = MutableLiveData<Int>().apply {
        value = 0
    }
    val totalBooks: LiveData<Int> = _totalBooks

    private val _readBooks = MutableLiveData<Int>().apply {
        value = 0
    }
    val readBooks: LiveData<Int> = _readBooks

    private val _recentBooks = MutableLiveData<List<Any>>().apply {
        value = emptyList()
    }
    val recentBooks: LiveData<List<Any>> = _recentBooks

    // TODO: Add methods to update statistics and load recent books
}
