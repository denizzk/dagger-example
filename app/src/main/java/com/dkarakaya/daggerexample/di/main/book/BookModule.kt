package com.dkarakaya.daggerexample.di.main.book

import com.dkarakaya.daggerexample.book.BookFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BookModule {

    @ContributesAndroidInjector(modules = [BookViewModelModule::class])
    fun contributeBookFragment(): BookFragment
}
