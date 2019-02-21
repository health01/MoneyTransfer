package com.example.moneytransfer.ui.result

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.moneytransfer.R
import com.example.moneytransfer.data.model.BalanceStatus
import com.example.moneytransfer.databinding.ActivityResultBinding
import com.example.moneytransfer.ui.transfer.TransferActivity.Companion.BALANCE_STATUS
import com.example.moneytransfer.util.Extension.decryption

class ResultActivity : AppCompatActivity() {
    lateinit var viewDataBinding: ActivityResultBinding
    lateinit var balanceStatus: BalanceStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        super.onCreate(savedInstanceState)
        initData()
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        balanceStatus = this.intent.extras.getSerializable(BALANCE_STATUS) as BalanceStatus
        viewDataBinding.txtStatus.text = "${this.getString(R.string.success)}: ${balanceStatus.success}"
        viewDataBinding.txtBalance.text = "${balanceStatus.data.balance.decryption} ${balanceStatus.data.currency}"
    }
}
