package com.yhz.my_book_collection.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yhz.my_book_collection.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupRecyclerView() {
        binding.recyclerViewSearchResults.layoutManager = LinearLayoutManager(requireContext())
        // TODO: Set adapter when data model is ready
    }

    private fun setupClickListeners() {
        // TODO: Setup search functionality and filter chips
        binding.chipAll.setOnClickListener {
            searchViewModel.setSearchFilter("all")
        }

        binding.chipBooks.setOnClickListener {
            searchViewModel.setSearchFilter("books")
        }

        binding.chipAuthors.setOnClickListener {
            searchViewModel.setSearchFilter("authors")
        }

        binding.chipCategories.setOnClickListener {
            searchViewModel.setSearchFilter("categories")
        }
    }

    private fun observeViewModel() {
        searchViewModel.searchResults.observe(viewLifecycleOwner) { results ->
            if (results.isEmpty()) {
                binding.layoutEmptyState.visibility = View.VISIBLE
                binding.recyclerViewSearchResults.visibility = View.GONE
            } else {
                binding.layoutEmptyState.visibility = View.GONE
                binding.recyclerViewSearchResults.visibility = View.VISIBLE
                // TODO: Update adapter with results
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
