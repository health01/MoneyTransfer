package com.example.moneytransfer.di

import android.arch.lifecycle.ViewModel
import com.example.moneytransfer.di.ViewModelKey
import com.example.moneytransfer.ui.signIn.SignInViewModel
import com.example.moneytransfer.ui.transfer.TransferViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    internal abstract fun bindSignInViewModel(repoViewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TransferViewModel::class)
    internal abstract fun bindTransferViewModel(repoViewModel: TransferViewModel): ViewModel
/*

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(repoViewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(BookMarkViewModel::class)
    internal abstract fun bindBookMarkViewModel(repoViewModel: BookMarkViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddToCartViewModel::class)
    internal abstract fun bindAddToCartViewModel(repoViewModel: AddToCartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopcartViewModel::class)
    internal abstract fun bindShopcartViewModel(repoViewModel: ShopcartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun bindSearchViewModel(repoViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonSettingViewModel::class)
    internal abstract fun bindPersonSettingViewModel(repoViewModel: PersonSettingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddressViewModel::class)
    internal abstract fun bindAddressViewModel(repoViewModel: AddressViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PayMethodViewModel::class)
    internal abstract fun bindPayMethodViewModel(repoViewModel: PayMethodViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyOrderViewModel::class)
    internal abstract fun bindMyOrderViewModel(repoViewModel: MyOrderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyOrderHistoryViewModel::class)
    internal abstract fun bindMyOrderHistoryViewModel(repoViewModel: MyOrderHistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrderDetailViewModel::class)
    internal abstract fun bindMyOrderDetailViewModel(repoViewModel: OrderDetailViewModel): ViewModel
*/


}