package com.dkarakaya.daggerexample.di.main

import com.dkarakaya.daggerexample.MainActivity
import com.dkarakaya.daggerexample.di.ViewModelModule
import com.dkarakaya.daggerexample.di.main.book.BookModule
import com.dkarakaya.daggerexample.di.main.character.CharacterModule
import com.dkarakaya.daggerexample.di.main.movie.MovieModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            BookModule::class,
            MovieModule::class,
            CharacterModule::class

        ]
    )
    fun contributeMainActivity(): MainActivity

}
