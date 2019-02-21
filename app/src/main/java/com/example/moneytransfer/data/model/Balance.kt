package com.example.moneytransfer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Balance(
    @Expose
    @SerializedName("balance")
    val balance: String,
    @Expose
    @SerializedName("currency")
    val currency: String
): Serializable