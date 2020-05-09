package com.dkarakaya.book.di

import com.dkarakaya.book.BookFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BookModule {

    @ContributesAndroidInjector(modules = [BookViewModelModule::class])
    fun contributeBookFragment(): BookFragment
}
