package com.example.moneytransfer.data.api


import io.reactivex.Observable
import java.util.*


class BalanceService : BaseDataService() {

    init {
        params = WeakHashMap<String, Any>()
    }


    fun login(email: String, password: String): Observable<String> {
        params.clear()
        params["email"] = email
        params["password"] = password
        return postData("login.php", params)
    }

    fun transfer(balance: String): Observable<String> {
        params.clear()
        params["balance"] = balance
        return postData("result.php", params)
    }


}