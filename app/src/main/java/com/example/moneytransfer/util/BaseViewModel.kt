/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.example.moneytransfer.util

import android.arch.lifecycle.*
import com.example.moneytransfer.util.log.KstLogger
import com.google.gson.Gson


import java.lang.ref.WeakReference

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Kit on 07/07/17.
 */

abstract class BaseViewModel<N> : ViewModel() {


    val isLoading = MutableLiveData<Boolean>()

    val isShowToast = MutableLiveData<Event<Boolean>>()
    val isTokenStatus = MutableLiveData<Event<Boolean>>()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()


    private var mNavigator: WeakReference<N>? = null

    var navigator: N
        get() = mNavigator!!.get()!!
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }

    override fun onCleared() {
//        compositeDisposable.dispose()
        compositeDisposable.clear()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }

    fun getIsLoading(): MutableLiveData<Boolean> {
        return this.isLoading
    }

    fun setToastStatus(isShowToast: Boolean) {
        this.isShowToast.value = Event(isShowToast)
    }

    fun getToastStatus(): MutableLiveData<Event<Boolean>> {
        return this.isShowToast
    }


    //TODO:mapToModel
    inline fun <reified T> mapToModel(json: String): T {
        KstLogger.d("請求-Result = $json")
        return Gson().fromJson(json, T::class.java) as T
    }


}
