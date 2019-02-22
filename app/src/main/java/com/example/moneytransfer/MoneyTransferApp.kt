package com.example.moneytransfer

import android.app.Activity
import android.app.Application
import com.example.moneytransfer.util.app.AppController
import com.example.moneytransfer.di.AppInjector
import com.example.moneytransfer.util.app.network.TokenInterceptor
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class MoneyTransferApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        AppController.init(this)
            .withInterceptor(TokenInterceptor())
//            .withLoaderDelayed(2000)
            .withApiHost("http://188.166.219.109/test/moneytranster/api/")
            .configure()
        AppInjector.init(this)

    }


}
