package com.dkarakaya.daggerexample.di.main.movie

import com.dkarakaya.daggerexample.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MovieModule {

    @ContributesAndroidInjector(
        modules = [MovieViewModelModule::class]
    )
    fun contributeMovieFragment(): MovieFragment
}
