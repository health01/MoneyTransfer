package com.example.moneytransfer.di

import com.example.moneytransfer.MoneyTransferApp
import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuildersModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MoneyTransferApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: MoneyTransferApp)
}