package com.dkarakaya.daggerexample.di.main.book

import androidx.lifecycle.ViewModel
import com.dkarakaya.daggerexample.book.BookViewModel
import com.dkarakaya.daggerexample.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface BookViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookViewModel::class)
    fun bindBookViewModel(bookViewModel: BookViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun provideBookViewModel(): BookViewModel = BookViewModel()
    }
}
