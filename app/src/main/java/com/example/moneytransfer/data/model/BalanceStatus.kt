package com.example.moneytransfer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BalanceStatus(
    @Expose
    @SerializedName("success")
    var success: Boolean,
    @Expose
    @SerializedName("data")
    var data: Balance
) :  Serializable