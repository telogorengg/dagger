package com.example.daggerlearning.data.repository

import com.example.daggerlearning.data.api.ApiService
import com.example.daggerlearning.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val apiService: ApiService) : Repository {
    override fun getUser(
        username: String,
        onSuccess: (user: User) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        super.getUser(username, onSuccess, onFailure)

        apiService.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    onSuccess.invoke(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }

        })
    }
}