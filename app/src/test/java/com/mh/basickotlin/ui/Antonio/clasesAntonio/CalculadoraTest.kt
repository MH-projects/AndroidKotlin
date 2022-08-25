package com.mh.basickotlin.ui.Antonio.clasesAntonio

import com.mh.basickotlin.ui.manuel.Calculator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculadoraTest{

    private lateinit var calculatora: Calculadora

    @Before
    fun init() {
        calculatora = Calculadora()
    }

    @Test
    fun `test convert string to int`() {
        val result = calculatora.convertirStringAInt("15")
        assertEquals(15, result)
    }

    @Test
    fun `test of plus of two numbers`() {
        val result = calculatora.suma(13, 2)
        assertEquals("Error en la prueba", 15, result)
    }


    @Test
    fun `test of minus of two numbers`() {
        val result = calculatora.resta(13, 2)
        assertEquals("Error en la prueba", 11, result)
    }

    @Test
    fun `test of times of two numbers`() {
        val result = calculatora.multi(3, 2)
        assertEquals("Error en la prueba", 6, result)
    }


    @Test
    fun `test of div of two numbers`() {
        val result = calculatora.div(12, 2)
        assertEquals("Error en la prueba", 6, result)
    }
}