package com.example.moneytransfer.util.network.callback

/**
 * Created by Sai on 2017/9/25.
 */

interface IError {

    fun onError(code: Int, msg: String)
}
