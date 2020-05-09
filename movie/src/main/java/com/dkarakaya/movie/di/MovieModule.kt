package com.dkarakaya.movie.di

import com.dkarakaya.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MovieModule {

    @ContributesAndroidInjector(
        modules = [MovieViewModelModule::class]
    )
    fun contributeMovieFragment(): MovieFragment
}
