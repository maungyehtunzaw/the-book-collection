package com.yhz.my_book_collection.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yhz.my_book_collection.R
import com.yhz.my_book_collection.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        // Setup login button
        binding.buttonLogin.setOnClickListener {
            performLogin()
        }

        // Setup register link
        binding.textRegisterLink.setOnClickListener {
            findNavController().navigate(R.id.nav_register)
        }
    }

    private fun performLogin() {
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Simple validation - in a real app, you'd authenticate with a server
        if (email.contains("@") && password.length >= 6) {
            // Save login state
            with(sharedPreferences.edit()) {
                putBoolean("is_logged_in", true)
                putString("user_email", email)
                apply()
            }

            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()

            // Navigate back to profile
            findNavController().navigate(R.id.nav_profile)
        } else {
            Toast.makeText(context, "Invalid email or password (min 6 chars)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
