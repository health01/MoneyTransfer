package com.example.moneytransfer.di

import com.example.moneytransfer.data.api.BalanceService
import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module(
    includes = arrayOf(
        ViewModelModule::class
    )
)
class AppModule {
    @Provides
    @Singleton
    fun signService(): BalanceService {
        return BalanceService()
    }




}
