package com.mh.basickotlin.ui.pablo

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorPabloTest {

    private lateinit var calculator: CalculatorPablo

    @Before
    fun init() {
        calculator = CalculatorPablo()
    }

    @Test
    fun `test convert string to int`() {
        val result = calculator.convertStringToInt("15")
        assertEquals(15, result)
    }

    @Test
    fun `test convert string to int with empty parameter`() {
        val result = calculator.convertStringToInt("")
        assertEquals(0, result)
    }

    @Test
    fun `test of plus of two numbers`() {
        val result = calculator.plus(10, 5)
        assertEquals("Prueba de suma  exitosa", 15, result)
    }

    @Test
    fun `test of minus of two numbers`() {
        val result = calculator.minus(10, 5)
        assertEquals("Prueba de resta  exitosa", 5, result)
    }

    @Test
    fun `test of times of two numbers`() {
        val result = calculator.times(10, 5)
        assertEquals("Prueba de resta  exitosa", 50, result)
    }

    @Test
    fun `test of division of two numbers`() {
        val result = calculator.div(10, 5)
        assertEquals("Prueba de resta  exitosa", 2, result)
    }

    @Test
    fun `divide by 0 test`() {
        val result = calculator.div(10, 0)
        assertEquals("Prueba de resta  exitosa", -1, result)
    }
}
