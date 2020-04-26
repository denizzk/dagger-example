package com.dkarakaya.daggerexample.di

import androidx.lifecycle.ViewModelProvider
import com.dkarakaya.daggerexample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
