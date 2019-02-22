package com.example.moneytransfer.util.Encryption

import android.support.test.runner.AndroidJUnit4
import com.example.moneytransfer.BuildConfig
import com.example.moneytransfer.util.EncryptUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * AES encryption test
 */

@RunWith(AndroidJUnit4::class)
class EncryptorTest {

    @Test
    fun encrypt() {

        Assert.assertEquals("CqEwo/LDaiaW04njfK8paw==",  Encryptor.encrypt(BuildConfig.pin,BuildConfig.initvetor,"1234567890"))

        Assert.assertEquals("CqEwo/LDaiaW04njfK8paw==", EncryptUtils.encrypt("1234567890"))
        Assert.assertNotEquals("CqEwo/LDaiaW04njfK8paw==",  EncryptUtils.encrypt("12345678903"))
    }

    @Test
    fun decrypt() {
        Assert.assertEquals("1234567890", Encryptor.decrypt(BuildConfig.pin,BuildConfig.initvetor,"CqEwo/LDaiaW04njfK8paw=="))

        Assert.assertEquals("1234567890", EncryptUtils.decrypt("CqEwo/LDaiaW04njfK8paw=="))
        Assert.assertNotEquals("12345678901",  EncryptUtils.encrypt("CqEwo/LDaiaW04njfK8paw=="))
    }
}