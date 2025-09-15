package com.yhz.my_book_collection.data.repository

import com.yhz.my_book_collection.data.model.LoginResponse
import com.yhz.my_book_collection.data.model.User
import com.yhz.my_book_collection.data.remote.AuthApiService
import com.yhz.my_book_collection.data.remote.LoginRequest
import com.yhz.my_book_collection.data.remote.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val authApiService: AuthApiService) {

    // A simple in-memory cache for the current user and token
    // In a real app, you'd use SharedPreferences or a database for persistence.
    var currentUser: User? = null
    var authToken: String? = null

    suspend fun login(email: String, password: String): Result<LoginResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = authApiService.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        currentUser = loginResponse.user
                        authToken = loginResponse.token
                        Result.success(loginResponse)
                    } else {
                        Result.failure(Exception("Empty response body"))
                    }
                } else {
                    // Consider parsing error body for more specific messages
                    Result.failure(Exception("Login failed: ${response.code()} ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun register(username: String, email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = authApiService.register(RegisterRequest(username, email, password))
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        Result.success(registerResponse.user)
                    } else {
                        Result.failure(Exception("Empty response body"))
                    }
                } else {
                    Result.failure(Exception("Registration failed: ${response.code()} ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    fun logout() {
        // Clear cached user and token
        currentUser = null
        authToken = null
        // TODO: Add any server-side logout calls if necessary
    }

    fun isLoggedIn(): Boolean {
        return currentUser != null && authToken != null
    }
}
