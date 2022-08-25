package com.mh.basickotlin.ui.angel

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class OperatorsTest {
    private lateinit var operators: Operators

    @Before
    fun iniciar() {
        operators = Operators()
    }

    @Test
    fun `convert String to Int`() {
        val result = operators.conString("123")
        assertEquals(123, result)
    }

    @Test
    fun `Suma de dos numeros`() {
        val result = operators.plus(20, 30)
        assertEquals(50, result)
    }

    @Test
    fun `Test de resta de numeros enteros`() {
        val result = operators.less(20, 30)
        assertEquals(-10, result)
    }

    @Test
    fun `Test de multiplicacion de numeros enteros`() {
        val result = operators.by(20, 30)
        assertEquals(600, result)
    }
    @Test
    fun `Test de division de numeros enteros`() {
        val result = operators.split(60, 30)
        assertEquals(2, result)
    }
}
