package com.example.moneytransfer.util.Extension

import org.junit.Assert
import org.junit.Test


class StringExtentionKtTest {

    @Test
    fun getMd5() {
        Assert.assertEquals("54cbde3f136b4675e545f0ea906aa2b0", ("=tyqwert").md5)
    }

    @Test
    fun isDigitalAndLetter() {
        Assert.assertFalse(("123456").isDigitalAndLetter)
        Assert.assertTrue(("12345aa").isDigitalAndLetter)
    }


}