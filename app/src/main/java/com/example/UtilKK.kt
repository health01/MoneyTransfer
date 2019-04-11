package com.example


object UtilKotlinObj {
    fun ok(): String {
        return "UtilKotlin.ok()"
    }
}

class UtilKotlin {
    companion object {
        @JvmStatic
        fun ok(): String {
            return "UtilKotlin.ok()"
        }
    }
}