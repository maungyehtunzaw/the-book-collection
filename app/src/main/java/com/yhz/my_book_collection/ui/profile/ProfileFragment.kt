package com.yhz.my_book_collection.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yhz.my_book_collection.R
import com.yhz.my_book_collection.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        // Check if user is logged in
        val isLoggedIn = sharedPreferences.getBoolean("is_logged_in", false)

        if (!isLoggedIn) {
            // Navigate to login if not logged in
            findNavController().navigate(R.id.nav_login)
            return
        }

        // Display user information
        val userEmail = sharedPreferences.getString("user_email", "")
        binding.textUserEmail.text = userEmail

        // Setup logout button
        binding.buttonLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        with(sharedPreferences.edit()) {
            putBoolean("is_logged_in", false)
            remove("user_email")
            apply()
        }

        // Navigate to login after logout
        findNavController().navigate(R.id.nav_login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
