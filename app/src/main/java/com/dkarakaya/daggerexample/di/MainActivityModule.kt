package com.dkarakaya.daggerexample.di

import com.dkarakaya.daggerexample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivity(): MainActivity

}
