package com.example.moneytransfer.ui.transfer


import android.arch.lifecycle.MutableLiveData
import com.example.moneytransfer.R
import com.example.moneytransfer.util.app.BaseFormFields

class TransferFormFields : BaseFormFields() {


    var balance: String? = null
        set(balance) {
            field = balance
            onValidation()
        }

    fun isBalanceValid(): Boolean {
        return balance != null && balance!!.length > 2
    }

    //    @Bindable
    //TODO:驗證表單
    override fun onValidation(): Boolean {
        var valid = isBalanceValid()
        isValid.value = valid
        return valid
    }


}