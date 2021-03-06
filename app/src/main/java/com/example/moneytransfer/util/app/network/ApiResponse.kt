package com.example.moneytransfer.util.app.network

import android.content.Context
import com.example.moneytransfer.util.log.KstLogger
import com.example.moneytransfer.util.network.ApiErrorModel
import com.example.moneytransfer.util.network.ApiErrorType
import com.google.gson.Gson
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class ApiResponse<T>(private val context: Context) : DisposableObserver<T>() {
    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)

//    override fun onSubscribe(d: Disposable) {
//        LoadingDialog.show(context)
//    }

    override fun onNext(t: T) {
        KstLogger.d("Response_onNext", t.toString())

        if (t != null) {
            success(t)
        }

    }

    override fun onComplete() {
//        LoadingDialog.cancel()
    }

    override fun onError(e: Throwable) {
//        LoadingDialog.cancel()
        if (e is HttpException) {
            val apiErrorModel: ApiErrorModel = when (e.code()) {
                ApiErrorType.INTERNAL_SERVER_ERROR.code ->
                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
                ApiErrorType.BAD_GATEWAY.code ->
                    ApiErrorType.BAD_GATEWAY.getApiErrorModel(context)
                ApiErrorType.NOT_FOUND.code ->
                    ApiErrorType.NOT_FOUND.getApiErrorModel(context)
                else -> otherError(e)

            }
            failure(e.code(), apiErrorModel)
            return
        }

        val apiErrorType: ApiErrorType = when (e) {
            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
            is SocketTimeoutException -> ApiErrorType.CONNECTION_TIMEOUT
            else -> ApiErrorType.UNEXPECTED_ERROR
        }
        failure(apiErrorType.code, apiErrorType.getApiErrorModel(context))
        KstLogger.d("Response_onError", apiErrorType.toString())
    }

    private fun otherError(e: HttpException) =
        Gson().fromJson(e.response().errorBody()?.charStream(), ApiErrorModel::class.java)
}
