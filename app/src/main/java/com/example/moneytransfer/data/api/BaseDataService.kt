package com.example.moneytransfer.data.api

import com.example.moneytransfer.util.network.rx.RxRestClient
import com.google.gson.Gson
import io.reactivex.Observable
import java.util.*
open class BaseDataService {

        lateinit var params: WeakHashMap<String, Any>
//

    fun getData(url: String, params: WeakHashMap<String, Any>? = null): Observable<String> {
        val aa = RxRestClient.builder()
            .url(url)

        if (params != null) {
            aa.params(params)
        }

        return aa.build().get()
    }

    fun postData(url: String, params: WeakHashMap<String, Any>): Observable<String> {
        val aa = RxRestClient.builder()
            .url(url)
            .params(params)
            .build()

        return aa.post()
    }


}