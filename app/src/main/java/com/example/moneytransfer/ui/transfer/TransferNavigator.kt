package com.example.moneytransfer.ui.transfer

import com.example.moneytransfer.data.model.BalanceStatus


interface TransferNavigator {

    fun goToResultActivity(any: BalanceStatus)
    fun goToLogin()

}