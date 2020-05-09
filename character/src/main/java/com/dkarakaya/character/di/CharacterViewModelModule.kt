package com.dkarakaya.character.di

import androidx.lifecycle.ViewModel
import com.dkarakaya.character.CharacterViewModel
import com.dkarakaya.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface CharacterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    fun bindCharacterViewModel(characterViewModel: CharacterViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun provideCharacterViewModel(): CharacterViewModel =
            CharacterViewModel()
    }
}
