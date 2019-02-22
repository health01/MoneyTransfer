package com.example.moneytransfer.ui.transfer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.databinding.DataBindingUtil
import android.widget.Toast
import com.example.moneytransfer.R
import com.example.moneytransfer.data.model.BalanceStatus
import com.example.moneytransfer.databinding.ActivityTransferBinding
import com.example.moneytransfer.di.Injectable
import com.example.moneytransfer.ui.result.ResultActivity
import com.example.moneytransfer.ui.signIn.SignInActivity
import com.example.moneytransfer.viewmodel.ViewModelFactory
import javax.inject.Inject


class TransferActivity : AppCompatActivity(), TransferNavigator, Injectable {

    companion object {
        val BALANCE_STATUS = "BALANCE_STATUS"
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var transferViewModel: TransferViewModel
    lateinit var viewDataBinding: ActivityTransferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        transferViewModel = ViewModelProviders.of(this, factory).get(TransferViewModel::class.java)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_transfer)

        initView()
        initProcess()

    }

    private fun initView() {
        viewDataBinding.run {
            viewModel = transferViewModel
            lifecycleOwner = this@TransferActivity
        }

    }

    private fun initProcess() {
        transferViewModel.run {
            navigator = this@TransferActivity

            isShowToast.observe(this@TransferActivity, Observer {
                it?.getContentIfNotHandled()?.let {
                    Toast.makeText(this@TransferActivity, getString(R.string.error_login_error), Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_logout -> {
                transferViewModel.logout()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun goToLogin() {
        startActivity(Intent(this@TransferActivity, SignInActivity::class.java))
        finish()
    }


    override fun goToResultActivity(data: BalanceStatus) {
        val intent = Intent(this@TransferActivity, ResultActivity::class.java)
        intent.putExtra(BALANCE_STATUS, data)
        startActivity(intent)
//        finish()
    }
}
