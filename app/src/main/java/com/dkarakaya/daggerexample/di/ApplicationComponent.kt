package com.dkarakaya.daggerexample.di

import com.dkarakaya.daggerexample.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(instance: BaseApplication?) = Unit
}
