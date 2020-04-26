package com.dkarakaya.daggerexample.di.main.character

import com.dkarakaya.daggerexample.character.CharacterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CharacterModule {

    @ContributesAndroidInjector(
        modules = [CharacterViewModelModule::class]
    )
    fun contributeCharacterFragment(): CharacterFragment
}
