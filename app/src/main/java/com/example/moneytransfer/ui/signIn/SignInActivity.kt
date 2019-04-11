package com.example.moneytransfer.ui.signIn

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.util.ArrayMap
import android.widget.Toast
import com.example.moneytransfer.R
import com.example.moneytransfer.databinding.ActivityLoginBinding
import com.example.moneytransfer.di.Injectable
import com.example.moneytransfer.ui.transfer.TransferActivity
import javax.inject.Inject

class SignInActivity : AppCompatActivity(), SigInNavigator, Injectable {




    @VisibleForTesting
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var signInViewModel: SignInViewModel
    lateinit var viewDataBinding: ActivityLoginBinding

    lateinit var data: ArrayMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        signInViewModel = ViewModelProviders.of(this, factory).get(SignInViewModel::class.java)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        data = ArrayMap<String, String>()
//       var  adad = data["hujhu"] = ""

        var uiui = getHAHA(true)

        initView()
        initProcess()
        signInViewModel.checkLogin()

        userPressedButton()

    }

    private fun initView() {
        viewDataBinding.run {
            viewModel = signInViewModel
            lifecycleOwner = this@SignInActivity
        }
    }

    fun getHAHA(bool: Boolean): ArrayMap<String, String> {
        return when (bool) {
            true -> {
                this.data.apply {
                    this["BBBB"] = "BBBB"
                }
            }
            else -> {
                this.data.also { it["aaaa"] = "aaaa" }
            }
        }
    }

    private fun initProcess() {
        signInViewModel.run {
            navigator = this@SignInActivity
            isShowToast.observe(this@SignInActivity, Observer {
                it?.getContentIfNotHandled()?.let {
                    Toast.makeText(this@SignInActivity, getString(R.string.error_login_error), Toast.LENGTH_LONG)
                        .show()
                }
            })

        }
    }

    override fun goToTransferActivity() {
        startActivity(Intent(this@SignInActivity, TransferActivity::class.java))
        finish()
    }

    fun userPressedButton() {
        this.ttest()
    }

    override fun ttest() {
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
    }

}
