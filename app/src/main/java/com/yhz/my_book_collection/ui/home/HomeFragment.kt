package com.yhz.my_book_collection.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yhz.my_book_collection.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupRecyclerView() {
        binding.recyclerViewRecentBooks.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        // TODO: Set adapter when data model is ready
    }

    private fun setupClickListeners() {
        binding.btnAddBook.setOnClickListener {
            // TODO: Navigate to add book screen
        }

        binding.btnBrowseBooks.setOnClickListener {
            // TODO: Navigate to browse fragment
        }
    }

    private fun observeViewModel() {
        // TODO: Observe LiveData from ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
