package com.yhz.my_book_collection.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yhz.my_book_collection.databinding.ActivityLoginBinding
import com.yhz.my_book_collection.ui.register.RegisterActivity // Assuming RegisterActivity will be created

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    // private lateinit var loginViewModel: LoginViewModel // Will be added later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // loginViewModel = ViewModelProvider(this, LoginViewModelFactory(AuthRepository(ApiClient.authService))) // Will be added later
        //     .get(LoginViewModel::class.java)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Implement login logic with ViewModel
            // loginViewModel.login(email, password)
             Toast.makeText(this, "Login Clicked (Not Implemented)", Toast.LENGTH_SHORT).show()
        }

        binding.textViewGoToRegister.setOnClickListener {
            // Intent to RegisterActivity
             startActivity(Intent(this, RegisterActivity::class.java)) // Assuming RegisterActivity will be created
        }

        // observeLoginResult() // Will be added later
    }

    // private fun observeLoginResult() { // Will be added later
    //     loginViewModel.loginResult.observe(this) { result ->
    //         result.onSuccess {
    //             // Navigate to main screen or profile page
    //             Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
    //             // Example: startActivity(Intent(this, MainActivity::class.java))
    //             // finish()
    //         }.onFailure { exception ->
    //             Toast.makeText(this, "Login Failed: ${exception.message}", Toast.LENGTH_LONG).show()
    //         }
    //     }
    // }
}
