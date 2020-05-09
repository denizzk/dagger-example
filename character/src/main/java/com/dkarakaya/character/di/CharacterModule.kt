package com.dkarakaya.character.di

import com.dkarakaya.character.CharacterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CharacterModule {

    @ContributesAndroidInjector(
        modules = [CharacterViewModelModule::class]
    )
    fun contributeCharacterFragment(): CharacterFragment
}
