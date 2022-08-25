package com.mh.basickotlin.ui.juan.activity

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `test of plus of two numbers`() {
        val result = calculator.suma(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }

    @Test
    fun `test of rest of two numbers`() {
        val result = calculator.resta(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }

    @Test
    fun `test of product of two numbers`() {
        val result = calculator.mult(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }

    @Test
    fun `test of div of two numbers`() {
        val result = calculator.div(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }
}
