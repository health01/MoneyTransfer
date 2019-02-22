package com.example.moneytransfer.data.repository


import com.example.moneytransfer.data.api.BalanceService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BalanceRepository @Inject constructor(private val balanceService: BalanceService) {

    fun login(email: String, password: String): Observable<String> {
        return balanceService.login(email, password)
    }

    fun transfer(balance: String): Observable<String> {
        return balanceService.transfer(balance)
    }


}