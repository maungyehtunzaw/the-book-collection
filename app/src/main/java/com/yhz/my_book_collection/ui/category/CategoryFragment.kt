package com.yhz.my_book_collection.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yhz.my_book_collection.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCategories.layoutManager = GridLayoutManager(requireContext(), 2)
        // TODO: Set adapter when data model is ready
    }

    private fun setupClickListeners() {
        binding.fabAddCategory.setOnClickListener {
            // TODO: Show add category dialog
        }

        // TODO: Setup search functionality
    }

    private fun observeViewModel() {
        // TODO: Observe categories LiveData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
