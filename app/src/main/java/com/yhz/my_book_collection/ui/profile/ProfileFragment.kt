package com.yhz.my_book_collection.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yhz.my_book_collection.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupClickListeners()
        observeViewModel()

        return root
    }

    private fun setupClickListeners() {
        binding.btnEditProfile.setOnClickListener {
            // TODO: Navigate to edit profile screen
        }

        binding.btnExportData.setOnClickListener {
            // TODO: Implement export functionality
        }

        binding.btnAbout.setOnClickListener {
            // TODO: Show about dialog
        }
    }

    private fun observeViewModel() {
        profileViewModel.username.observe(viewLifecycleOwner) { username ->
            binding.textViewUsername.text = username
        }

        profileViewModel.userEmail.observe(viewLifecycleOwner) { email ->
            binding.textViewUserEmail.text = email
        }

        // TODO: Observe reading statistics
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
