package com.yhz.my_book_collection.ui.author

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yhz.my_book_collection.databinding.FragmentAuthorBinding

class AuthorFragment : Fragment() {

    private var _binding: FragmentAuthorBinding? = null
    private val binding get() = _binding!!

    private lateinit var authorViewModel: AuthorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        authorViewModel = ViewModelProvider(this).get(AuthorViewModel::class.java)

        _binding = FragmentAuthorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupRecyclerView() {
        binding.recyclerViewAuthors.layoutManager = LinearLayoutManager(requireContext())
        // TODO: Set adapter when data model is ready
    }

    private fun setupClickListeners() {
        // TODO: Setup search functionality
    }

    private fun observeViewModel() {
        // TODO: Observe authors LiveData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
