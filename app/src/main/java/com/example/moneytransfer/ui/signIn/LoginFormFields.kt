package com.example.moneytransfer.ui.signIn


import android.arch.lifecycle.MutableLiveData
import com.example.moneytransfer.util.app.BaseFormFields

class LoginFormFields : BaseFormFields() {
    var token = MutableLiveData<String>()


    //    @Bindable
    //TODO:驗證表單
    override fun onValidation(): Boolean {
        var valid = isEmailValid()
        valid = isPasswordValid() && valid
        isValid.value = valid
//        ToastUtils.showShort(valid.toString())
        return valid
    }


}