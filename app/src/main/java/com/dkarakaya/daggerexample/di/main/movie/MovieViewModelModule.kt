package com.dkarakaya.daggerexample.di.main.movie

import androidx.lifecycle.ViewModel
import com.dkarakaya.daggerexample.di.ViewModelKey
import com.dkarakaya.daggerexample.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface MovieViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun bindMovieViewModel(movieViewModel: MovieViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun provideMovieViewModel(): MovieViewModel = MovieViewModel()
    }
}
