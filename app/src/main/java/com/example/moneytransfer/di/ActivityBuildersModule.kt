package com.example.moneytransfer.di

import com.example.moneytransfer.ui.transfer.TransferActivity
import com.example.moneytransfer.ui.signIn.SignInActivity
import com.example.moneytransfer.ui.result.ResultActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): TransferActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSignInActivity(): SignInActivity

    @ContributesAndroidInjector
    internal abstract fun contributeResultActivity(): ResultActivity
}