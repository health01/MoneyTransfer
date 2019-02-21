package com.example.moneytransfer.data.repository


import com.example.moneytransfer.data.api.BalanceService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BalanceRepository @Inject constructor(private val balanceService: BalanceService) {

    //    private val balanceService: BalanceService = BalanceService()
    enum class ECodeType {
        forget(),
        register()
    }

    fun login(email: String, password: String): Observable<String> {
        return balanceService.login(email, password)
    }

    fun transfer(balance: String): Observable<String> {
        return balanceService.transfer(balance)
    }


/*

    //TODO:註冊
    fun register(
        nickName: String,
        email: String,
        password: String
    ): Observable<String> {
        return balanceService.Registration(nickName, email, password)
    }

    fun loginToken(): Observable<String> {
//        return getData("Mobile/LoginToken", params)
        return balanceService.LoginToken()
    }


    fun getUser(): Observable<String> {
        return balanceService.GetUser()
    }

    fun getAllMaster(): Observable<String> {
        return balanceService.GettAllMaster()
    }


    fun checkUserEmailExist(email: String): Observable<String> {
        return balanceService.CheckUserEmailExist(email)
    }

    fun resetPassword(email: String): Observable<String> {
        return balanceService.resetPassword(email)
    }
*/

}