package com.example.daggerlearning.di.module

import com.example.daggerlearning.data.api.ApiService
import com.example.daggerlearning.data.repository.Repository
import com.example.daggerlearning.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesUserRepository(apiService: ApiService): Repository {
        return UserRepository(apiService)
    }
}