package com.example.daggerlearning.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.daggerlearning.data.api.ApiService
import com.example.daggerlearning.databinding.ActivityMainBinding
import com.example.daggerlearning.di.component
import com.example.daggerlearning.ui.viewmodel.MainViewModel
import com.example.daggerlearning.utils.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        binding.search.setOnClickListener {
            mainViewModel.searchUser(binding.username.text.toString())
        }

        mainViewModel.fullname.observe(this, { username ->
            if(username.isNotEmpty()) {
                binding.fullName.text = username
            } else {
                Toast.makeText(this, "Username is not found", Toast.LENGTH_SHORT).show()
            }
        })
    }
}