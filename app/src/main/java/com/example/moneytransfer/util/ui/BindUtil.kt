package com.example.moneytransfer.util.ui

import android.databinding.BindingAdapter
import android.support.design.widget.TextInputLayout
import com.example.moneytransfer.util.app.AppController


object BindUtil {


    @JvmStatic
    fun string(resourceId: Int): String {
        return AppController.getApplication()
                .getResources()
                .getString(resourceId)
    }

    @BindingAdapter("error")
    @JvmStatic
    fun setError(editText: TextInputLayout, strOrResId: Any?) {
        if (strOrResId != null) {
            if (strOrResId is Int) {
                editText.error = editText.context.getString(strOrResId)
            } else {
                editText.error = strOrResId as String
            }
        } else {
            editText.error = strOrResId
        }

    }




}