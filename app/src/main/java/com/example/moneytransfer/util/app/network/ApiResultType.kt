package com.example.moneytransfer.util.app.network

import android.content.Context
import android.support.annotation.StringRes
import com.example.moneytransfer.R
import com.example.moneytransfer.util.network.ApiErrorModel


enum class ApiResultType(val code: Int, @param: StringRes private val messageId: Int) {
    SUCCESS_RESULT(200, R.string.api_success),
    FALSE_RESULT(400, R.string.api_failure),
    TOKEN_FAILED(410, R.string.token_failed);

    private val DEFAULT_CODE = 1

    fun getApiErrorModel(context: Context): ApiErrorModel {
        return ApiErrorModel(DEFAULT_CODE, context.getString(messageId))
    }
}