package com.example.moneytransfer.ui.transfer


import com.example.moneytransfer.data.model.BalanceStatus
import com.example.moneytransfer.util.app.AccountManager
import com.example.moneytransfer.util.app.AppController
import com.example.moneytransfer.data.repository.BalanceRepository
import com.example.moneytransfer.util.BaseViewModel
import com.example.moneytransfer.util.Extension.encryption
import com.example.moneytransfer.util.network.ApiErrorModel
import com.example.moneytransfer.util.app.network.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import plusAssign
import javax.inject.Inject


class TransferViewModel @Inject constructor(private val repository: BalanceRepository) :
    BaseViewModel<TransferNavigator>() {

    var form: TransferFormFields = TransferFormFields()

    fun logout() {
        if (AccountManager.isSignIn()) {
            AccountManager.logoutWithClear()
            navigator.goToLogin()
        }
    }

    fun onTransferClick() {
        if (form.onValidation()) {
            transfer(form.balance.toString())
        }
    }


    //TODO: transfer action
    private fun transfer(balance: String) {

        val transfer = repository.transfer(balance.encryption)
            .map {
                mapToModel<BalanceStatus>(it)
            }
        compositeDisposable +=
            transfer.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponse<BalanceStatus>(AppController.getApplication()) {
                    override fun success(data: BalanceStatus) {
                        navigator.goToResultActivity(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        setToastStatus(false)
                    }
                })
    }


}