package com.yhz.my_book_collection.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// import androidx.lifecycle.ViewModelProvider
import com.yhz.my_book_collection.databinding.ActivityProfileBinding
import com.yhz.my_book_collection.ui.login.LoginActivity // For logout redirection

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    // private lateinit var profileViewModel: ProfileViewModel // Will be added later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // profileViewModel = ViewModelProvider(this, ProfileViewModelFactory(UserRepository(ApiClient.userService), AuthRepository(ApiClient.authService))) // Will be added later
        //     .get(ProfileViewModel::class.java)

        // Load user data - Placeholder
        // profileViewModel.loadUserProfile() // Will be added later
        binding.textViewUsername.text = "User Name Placeholder"
        binding.textViewEmail.text = "user@example.com"


        binding.buttonEditProfile.setOnClickListener {
            // TODO: Navigate to an EditProfileActivity or show a dialog
            Toast.makeText(this, "Edit Profile Clicked (Not Implemented)", Toast.LENGTH_SHORT).show()
        }

        binding.buttonLogout.setOnClickListener {
            // TODO: Implement logout logic with ViewModel
            // profileViewModel.logout()
             Toast.makeText(this, "Logout Clicked (Not Implemented)", Toast.LENGTH_SHORT).show()
             // Redirect to LoginActivity after logout
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Clear back stack
            startActivity(intent)
            finish()
        }

        // observeUserProfile() // Will be added later
        // observeLogoutResult() // Will be added later
    }

    // private fun observeUserProfile() { // Will be added later
    //     profileViewModel.userProfile.observe(this) { user ->
    //         user?.let {
    //             binding.textViewUsername.text = it.username
    //             binding.textViewEmail.text = it.email
    //             // Load profile image using Glide or Picasso if you have an imageUrl
    //             // Glide.with(this).load(it.profileImageUrl).placeholder(R.drawable.sym_def_app_icon).into(binding.imageViewProfile)
    //         }
    //     }
    //
    //     profileViewModel.profileError.observe(this) { error ->
    //         error?.let {
    //             Toast.makeText(this, "Failed to load profile: $it", Toast.LENGTH_LONG).show()
    //         }
    //     }
    // }

    // private fun observeLogoutResult() { // Will be added later
    //     profileViewModel.logoutResult.observe(this) { success ->
    //         if (success) {
    //             Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show()
    //             // Redirect to LoginActivity
    //             val intent = Intent(this, LoginActivity::class.java)
    //             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Clear back stack
    //             startActivity(intent)
    //             finish()
    //         } else {
    //             Toast.makeText(this, "Logout Failed", Toast.LENGTH_SHORT).show()
    //         }
    //     }
    // }
}
