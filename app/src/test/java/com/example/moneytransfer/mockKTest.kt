package com.example.moneytransfer

import com.example.UtilKotlin
import com.example.UtilKotlinObj
import io.mockk.*
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import org.junit.*


class Mother {
    fun inform(money: Int) {
        println("媽媽我現在有 $money 元，我要跟你拿錢！")
    }

    fun giveMoney(): Int {
        return 100
    }
}



class Kid(private val mother: Mother) {
    var money = 0
        private set

    fun wantMoney() {
        mother.inform(money)
        money += mother.giveMoney()
    }
}

class mockKTest {
        @MockK
        lateinit var mother: Mother

        lateinit var kid: Kid

        @Before
        fun setUp() {
            MockKAnnotations.init(this)
            kid = Kid(mother)
        }

    @Test
    fun wantMoney() {
        // When
        val mother = mockk<Mother>()
        val kid = Kid(mother)
        every { mother.giveMoney() } returns 30
        every { mother.inform(any()) } just Runs

        // Given
        kid.wantMoney()

        // Then
        verify { mother.inform(any()) }
        assertEquals(30, kid.money)
    }


    @Test
    fun ok2() {
        // Given
        val util = UtilKotlin
        mockkObject(UtilKotlin)
        mockkObject(UtilKotlin.Companion)

        every { UtilKotlin.ok() } returns "Tsai"

        // When
        util.ok()

        // Then
        verify { UtilKotlin.ok() }
        assertEquals("Tsai", UtilKotlin.ok())
    }

    @Test
    fun UtilKotlinObjTest() {
        // Given
        val util = UtilKotlinObj
        mockkObject(UtilKotlinObj)
        every { UtilKotlinObj.ok() } returns "Tsai"

        // When
        util.ok()

        // Then
        verify (exactly = 1){ UtilKotlinObj.ok() }
        assertEquals("Tsai", UtilKotlinObj.ok())
    }


}