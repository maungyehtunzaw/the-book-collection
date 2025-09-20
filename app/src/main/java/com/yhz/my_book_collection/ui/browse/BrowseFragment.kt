package com.yhz.my_book_collection.ui.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yhz.my_book_collection.databinding.FragmentBrowseBinding

class BrowseFragment : Fragment() {

    private var _binding: FragmentBrowseBinding? = null
    private val binding get() = _binding!!

    private lateinit var browseViewModel: BrowseViewModel
    private var isGridView = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        browseViewModel = ViewModelProvider(this).get(BrowseViewModel::class.java)

        _binding = FragmentBrowseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupRecyclerView() {
        updateLayoutManager()
        // TODO: Set adapter when data model is ready
    }

    private fun updateLayoutManager() {
        binding.recyclerViewBooks.layoutManager = if (isGridView) {
            GridLayoutManager(requireContext(), 2)
        } else {
            LinearLayoutManager(requireContext())
        }
    }

    private fun setupClickListeners() {
        binding.btnFilter.setOnClickListener {
            // TODO: Show filter dialog
        }

        binding.btnSort.setOnClickListener {
            // TODO: Show sort dialog
        }

        binding.btnGridView.setOnClickListener {
            isGridView = true
            updateLayoutManager()
        }

        binding.btnListView.setOnClickListener {
            isGridView = false
            updateLayoutManager()
        }
    }

    private fun observeViewModel() {
        // TODO: Observe books LiveData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
