package com.example.moneytransfer.util.app

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.ObservableField
import com.example.moneytransfer.R
import com.example.moneytransfer.util.Extension.isDigitalAndLetter
import com.example.moneytransfer.util.Extension.isDigitsOnly
import com.example.moneytransfer.util.Extension.isValidEmail

open class BaseFormFields : BaseObservable() {

    var nameError = ObservableField<Int>()
    var emailError = ObservableField<Int>()
    var codeError = ObservableField<Int>()
    var phoneError = ObservableField<Int>()
    var passportError = ObservableField<Int>()

    var passwordError = ObservableField<Int>()
    var confirmPasswordError = ObservableField<Int>()

    var isValid = MutableLiveData<Boolean>()

    //TODO:用戶名
    var name: String? = null
        set(name) {
            field = name
            onValidation()
            isNameValid(true)
        }

    //TODO:Email
    // Notify that the valid property could have changed.
    var email: String? = null
        set(email) {
            field = email
            onValidation()
            isEmailValid(true)

        }

    //TODO:驗證碼
    var code: String? = null
        set(code) {
            field = code
            onValidation()
            isCodeValid(true)
        }

    //TODO:電話
    var phone: String? = null
        set(phone) {
            field = phone
            onValidation()
            isPhoneValid(true)
        }

    //TODO:護照
    var passport: String? = null
        set(passport) {
            field = passport
            onValidation()
            isPassortValid(true)
        }


    var password: String? = null
        set(password) {
            field = password
            onValidation()
            isPasswordValid(true)
        }

    var cofirmPassword: String? = null
        set(password) {
            field = password
            onValidation()
            isConfirmPasswordValid(true)
        }


    //    @Bindable
    //TODO:驗證表單
    open fun onValidation(): Boolean {
        var valid = isEmailValid()
        valid = isNameValid() && valid
        valid = isCodeValid() && valid
        valid = isPhoneValid() && valid
        valid = isPassortValid() && valid

        isValid.value = valid
        return valid
    }

    //TODO:驗證用戶名
    fun isNameValid(setMessage: Boolean? = false): Boolean {
        return if (name != null) {
            nameError.set(null)
            true
        } else {
            if (setMessage!!)
                nameError.set(R.string.err_name)
            false
        }

    }

    //TODO:驗證Email
    fun isEmailValid(setMessage: Boolean? = false): Boolean {

        return return if (email != null && email!!.isValidEmail) {
            emailError.set(null)
            true
        } else {
            if (setMessage!!)
                emailError.set(R.string.err_email_format)
            false
        }

    }

    //TODO:驗證驗證碼
    fun isCodeValid(setMessage: Boolean? = false): Boolean {
        return if (this.code != null && this.code!!.length == 6) {
            codeError.set(null)
            true
        } else {
            if (setMessage!!)
                codeError.set(R.string.error_code)
            false
        }
    }

    //TODO:驗證電話
    fun isPhoneValid(setMessage: Boolean? = false): Boolean {
        return if (this.phone != null && this.phone!!.length in 8..11 && this.phone!!.isDigitsOnly) {
            phoneError.set(null)
            true
        } else {
            if (setMessage!!)
                phoneError.set(R.string.error_phone)
            false
        }
    }

    //TODO:驗證護照
    fun isPassortValid(setMessage: Boolean? = false): Boolean {
        return if (this.passport != null && this.passport!!.length > 5) {
            passportError.set(null)
            true
        } else {
            if (setMessage!!)
                passportError.set(R.string.error_id)
            false
        }
    }

    //TODO:驗證密碼
    fun isPasswordValid(setMessage: Boolean? = false): Boolean {
        return if (this.password != null && (this.password!!.length in 6..16) && this.password.toString().isDigitalAndLetter) {
            passwordError.set(null)
            true
        } else {
            if (setMessage!!)
                passwordError.set(R.string.err_email_length)
            false
        }

    }

    //TODO:驗證密碼
    fun isConfirmPasswordValid(setMessage: Boolean? = false): Boolean {
        return if (this.password != null && this.password == this.cofirmPassword) {
            confirmPasswordError.set(null)
            true
        } else {
            if (setMessage!!)
                confirmPasswordError.set(R.string.error_confirm_password)
            false
        }

    }


}
