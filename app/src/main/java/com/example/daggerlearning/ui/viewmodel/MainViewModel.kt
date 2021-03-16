package com.example.daggerlearning.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerlearning.data.api.ApiService
import com.example.daggerlearning.data.model.User
import com.example.daggerlearning.data.repository.Repository
import com.example.daggerlearning.data.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _fullname = MutableLiveData<String>()

    val fullname: LiveData<String>
        get() = _fullname

    fun searchUser(username: String) {
        repository.getUser(
            username,
            { user -> _fullname.value = user.name },
            { _fullname.value = null }
        )
    }
}