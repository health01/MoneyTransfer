package com.example.moneytransfer.util.Extension

import android.os.Build
import android.text.Html
import android.text.TextUtils
import com.example.moneytransfer.util.EncryptUtils
import java.math.BigInteger
import java.security.MessageDigest
import java.util.regex.Pattern


val String.md5: String?
    get() {
        try {
            // 生成一个MD5加密计算摘要
            val md = MessageDigest.getInstance("MD5")
            // 计算md5函数
            md.update(this.toByteArray())
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return BigInteger(1, md.digest()).toString(16)
        } catch (e: Exception) {
            // throw SpeedException("MD5加密出现错误")
            print(e)
        }
        return null
    }

val String.toHtmlText: String?
    get() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT).toString()
            } else {
                return Html.fromHtml(this).toString()
            }

        } catch (e: Exception) {
            // throw SpeedException("MD5加密出现错误")
            print(e)
        }
        return null
    }

val String.isValidEmail: Boolean
    get() {
        return if (TextUtils.isEmpty(this)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
        }
    }

val String.isDigitsOnly: Boolean
    get() {
        return if (TextUtils.isEmpty(this)) {
            false
        } else {
            TextUtils.isDigitsOnly(this)
        }
    }

val String.isDigitalAndLetter: Boolean
    get() {
        val letter = Pattern.compile("[a-zA-z]")
        val digit = Pattern.compile("[0-9]")
        val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
        val eight = Pattern.compile(".{8}")
        val hasLetter = letter.matcher(this)
        val hasDigit = digit.matcher(this)
        val hasSpecial = special.matcher(this)
        val hasEight = eight.matcher(this)
        return hasLetter.find() && hasDigit.find()

    }



val String.encryption: String
    get() {
        return EncryptUtils.encrypt(this)
    }

val String.decryption: String
    get() {
        return EncryptUtils.decrypt(this)
    }


