package com.example.daggerlearning.di.module

import com.example.daggerlearning.data.api.ApiService
import com.example.daggerlearning.data.repository.Repository
import com.example.daggerlearning.data.repository.UserRepository
import com.example.daggerlearning.utils.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {
    @Provides
    fun providesMainViewModelFactory(repository: Repository): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }
}