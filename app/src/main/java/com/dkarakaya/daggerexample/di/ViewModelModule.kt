package com.dkarakaya.daggerexample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dkarakaya.daggerexample.book.BookViewModel
import com.dkarakaya.daggerexample.character.CharacterViewModel
import com.dkarakaya.daggerexample.movie.MovieViewModel
import com.dkarakaya.daggerexample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BookViewModel::class)
    fun bindBookViewModel(bookViewModel: BookViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    fun bindCharacterViewModel(characterViewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun bindMovieViewModel(movieViewModel: MovieViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun provideBookViewModel(): BookViewModel = BookViewModel()

        @Provides
        fun provideCharacterViewModel(): CharacterViewModel = CharacterViewModel()

        @Provides
        fun provideMovieViewModel(): MovieViewModel = MovieViewModel()
    }
}
