package com.mh.basickotlin.manuel

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `test convert string to int`() {
        val result = calculator.convertStringToInt("15")
        assertEquals(15, result)
    }

    @Test
    fun `test of plus of two numbers`() {
        val result = calculator.suma(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }
}
