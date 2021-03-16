package com.example.daggerlearning.data.repository

import com.example.daggerlearning.data.model.User

interface Repository {
    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit) {

    }
}