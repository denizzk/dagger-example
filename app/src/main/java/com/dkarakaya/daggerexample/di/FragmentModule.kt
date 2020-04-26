package com.dkarakaya.daggerexample.di

import com.dkarakaya.daggerexample.book.BookFragment
import com.dkarakaya.daggerexample.character.CharacterFragment
import com.dkarakaya.daggerexample.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun contributeBookFragment(): BookFragment

    @ContributesAndroidInjector
    fun contributeCharacterFragment(): CharacterFragment

    @ContributesAndroidInjector
    fun contributeMovieFragment(): MovieFragment
}
