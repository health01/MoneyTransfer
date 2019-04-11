package com.example.moneytransfer.ui.signIn


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.core.internal.deps.guava.base.Joiner.on
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.moneytransfer.R
import com.example.moneytransfer.util.Extension.isValidEmail
import com.example.moneytransfer.util.app.AccountManager


import org.hamcrest.Matchers.not
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignInActivityTest {


    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<SignInActivity> = ActivityTestRule(SignInActivity::class.java)


    @Before
    @After
    fun setup() {
        AccountManager.logoutWithClear()
    }


    /**
    Test before login
     * */
    @Test
    fun loginActivityTest() {

        //login with wrong format
        onView(withId(R.id.edt_email)).perform(typeText("Jack"), closeSoftKeyboard())
        onView(withId(R.id.edt_pw)).perform(typeText("1234"), closeSoftKeyboard())
        //verify
        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())))

        //login with right format
        onView(withId(R.id.edt_email)).perform(replaceText("test@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.edt_pw)).perform(replaceText("12346a"), closeSoftKeyboard())
        //verify
        onView(withId(R.id.btn_login)).check(matches(isEnabled()))
        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.linear_transfer)).check(matches(isDisplayed()))
        Assert.assertTrue(mActivityTestRule.activity.isFinishing)

    }

    @Test
    fun isEmailVail() {
        Assert.assertTrue(("asd@gmail.com").isValidEmail)
        Assert.assertFalse(("^^@gmail.com").isValidEmail)
    }


}