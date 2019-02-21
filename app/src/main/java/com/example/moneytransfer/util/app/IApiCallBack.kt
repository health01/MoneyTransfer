package com.example.moneytransfer.util.app

//import com.kst.core.ui.loader.lemonLoader.DialogState


enum class HttpVeriDataResult {
    TOKEN_EXPIRED, FAILED
}

enum class ErrorType constructor(var value: Int) {
    NETWORK_FAILED(160315)
}

sealed class HttpErrorResult {
    data class TOKEN_EXPIRED(var msg: Any? = "請重新登錄") : HttpErrorResult()
    data class FAILED(var msg: Any? = null) : HttpErrorResult()
    data class NETWORK_FAILED(var msg: Any? = "沒有網路連線") : HttpErrorResult()
    //後面的 `:Destination()` 是 kotlin 繼承的語法
}


interface UIApiCallBack {
    fun onAction(response: Any)
//    fun onDialog(resultState: DialogState, message: Any)

}

interface HttpCallBackListener {
    fun onSuccess(resultObj: Any)
    fun onError(resultObj: HttpErrorResult)
}