package com.mh.basickotlin.ui.josue

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class OperationTest {
    private lateinit var metodsOperation: Operation

    @Before
    fun init() {
        metodsOperation = Operation()
    }

    @Test
    fun `test convert string to int`() {
        val result = metodsOperation.convertStringToInt("15")
        Assert.assertEquals(15, result)
    }

    @Test
    fun `test sum two numbers`() {
        val result = metodsOperation.suma(10, 16)
        Assert.assertEquals(26, result)
    }

    @Test
    fun `test minus two numbers`() {
        val result = metodsOperation.resta(10, 5)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `test times two numbers`() {
        val result = metodsOperation.multi(5, 2)
        Assert.assertEquals(10, result)
    }

    @Test
    fun `test div two numbers`() {
        val result = metodsOperation.div(5, 2)
        Assert.assertEquals(2, result)
    }
}
