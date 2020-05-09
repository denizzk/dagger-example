package com.dkarakaya.daggerexample.di

import com.dkarakaya.book.di.BookModule
import com.dkarakaya.character.di.CharacterModule
import com.dkarakaya.core.di.ViewModelModule
import com.dkarakaya.daggerexample.MainActivity
import com.dkarakaya.movie.di.MovieModule
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
