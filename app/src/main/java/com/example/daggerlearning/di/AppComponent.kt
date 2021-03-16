package com.example.daggerlearning.di

import com.example.daggerlearning.di.module.AppModule
import com.example.daggerlearning.di.module.RepositoryModule
import com.example.daggerlearning.di.module.ViewModelFactoryModule
import com.example.daggerlearning.ui.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}