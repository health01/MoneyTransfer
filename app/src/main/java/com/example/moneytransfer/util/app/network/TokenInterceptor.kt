package com.example.moneytransfer.util.app.network

import com.example.moneytransfer.util.app.AccountManager
import com.example.moneytransfer.util.network.interceptors.BaseInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class TokenInterceptor : BaseInterceptor() {
    internal var tokenKey = "accesstoken"
    internal var token = ""
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //TODO: INIT DATA
        token = AccountManager.getAuth()

        var request = chain.request()
        request = request.newBuilder()
            .addHeader(tokenKey, token)
            .build()
        return chain.proceed(request)


    }
}
