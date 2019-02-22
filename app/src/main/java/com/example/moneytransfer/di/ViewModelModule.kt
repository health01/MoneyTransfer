package com.example.moneytransfer.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.moneytransfer.data.repository.BalanceRepository
import com.example.moneytransfer.di.ViewModelKey
import com.example.moneytransfer.ui.signIn.SignInViewModel
import com.example.moneytransfer.ui.transfer.TransferViewModel
import com.example.moneytransfer.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(repoViewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TransferViewModel::class)
    abstract fun bindTransferViewModel(repoViewModel: TransferViewModel): ViewModel




}