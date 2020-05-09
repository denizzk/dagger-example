package com.dkarakaya.book.di

import androidx.lifecycle.ViewModel
import com.dkarakaya.book.BookViewModel
import com.dkarakaya.core.di.ViewModelKey
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
        fun provideBookViewModel(): BookViewModel =
            BookViewModel()
    }
}
