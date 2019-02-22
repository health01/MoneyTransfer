package com.example.moneytransfer.ui.signIn


import com.example.moneytransfer.data.model.LoginStatus
import com.example.moneytransfer.util.app.AccountManager
import com.example.moneytransfer.util.app.AppController
import com.example.moneytransfer.data.repository.BalanceRepository
import com.example.moneytransfer.util.BaseViewModel
import com.example.moneytransfer.util.Extension.encryption
import com.example.moneytransfer.util.Extension.md5
import com.example.moneytransfer.util.network.ApiErrorModel
import com.example.moneytransfer.util.app.network.ApiResponse
import com.example.moneytransfer.util.log.KstLogger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import plusAssign
import javax.inject.Inject


class SignInViewModel @Inject constructor(private val repository: BalanceRepository) : BaseViewModel<SigInNavigator>() {

    var form: LoginFormFields = LoginFormFields()

    fun checkLogin() {
        if (AccountManager.isSignIn()) {
            navigator.goToTransferActivity()
        }

    }

    fun onLoginClick() {
        if (form.isValid.value == true) {
            login(form.email!!, form.password!!)
        }
    }


    //TODO: login Call
    private fun login(email: String, password: String) {
        val loggin = repository.login(email, password.md5.toString()).map { mapToModel<LoginStatus>(it) }
        compositeDisposable +=
            loggin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponse<LoginStatus>(AppController.getApplication()) {
                    override fun success(data: LoginStatus) {

                        if (data.success) {
                            AccountManager.setAuth(data.auth.encryption)
                            AccountManager.setSignState(true)
                            navigator.goToTransferActivity()
                        }
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        setToastStatus(false)
                    }

                })
    }


}