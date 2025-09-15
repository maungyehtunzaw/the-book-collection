package com.yhz.my_book_collection.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yhz.my_book_collection.databinding.ActivityRegisterBinding
import com.yhz.my_book_collection.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    // private lateinit var registerViewModel: RegisterViewModel // Will be added later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // registerViewModel = ViewModelProvider(this, RegisterViewModelFactory(AuthRepository(ApiClient.authService))) // Will be added later
        //     .get(RegisterViewModel::class.java)

        binding.buttonRegister.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val confirmPassword = binding.editTextConfirmPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Implement registration logic with ViewModel
            // registerViewModel.register(username, email, password)
            Toast.makeText(this, "Register Clicked (Not Implemented)", Toast.LENGTH_SHORT).show()
        }

        binding.textViewGoToLogin.setOnClickListener {
            // Intent to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Finish RegisterActivity so user can't go back to it from LoginActivity
        }

        // observeRegisterResult() // Will be added later
    }

    // private fun observeRegisterResult() { // Will be added later
    //     registerViewModel.registerResult.observe(this) { result ->
    //         result.onSuccess {
    //             Toast.makeText(this, "Registration Successful. Please login.", Toast.LENGTH_LONG).show()
    //             // Navigate to login screen
    //             startActivity(Intent(this, LoginActivity::class.java))
    //             finishAffinity() // Clear back stack
    //         }.onFailure { exception ->
    //             Toast.makeText(this, "Registration Failed: ${exception.message}", Toast.LENGTH_LONG).show()
    //         }
    //     }
    // }
}
