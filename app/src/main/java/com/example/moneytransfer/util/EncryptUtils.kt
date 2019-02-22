package com.example.moneytransfer.util

import com.example.moneytransfer.BuildConfig
import com.example.moneytransfer.util.Encryption.Encryptor
import com.example.moneytransfer.util.log.KstLogger


class EncryptUtils {

    companion object {
        private val KEY = BuildConfig.pin
        private val INITVECTOR = BuildConfig.initvetor;// 16 bytes IV

        fun encrypt(json: String): String {
            return Encryptor.encrypt(KEY, INITVECTOR, json)
        }

        fun decrypt(json: String): String {
            KstLogger.d("decrypt from json-> $json")
            return Encryptor.decrypt(KEY, INITVECTOR, json)
        }
    }


}
