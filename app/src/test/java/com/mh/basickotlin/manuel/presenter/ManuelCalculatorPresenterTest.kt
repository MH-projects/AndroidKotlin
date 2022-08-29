package com.mh.basickotlin.manuel.presenter

import com.mh.basickotlin.manuel.presenter.contract.ManuelCalculatorContract
import com.mh.basickotlin.manuel.view.fragment.FrgManuelCalculator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ManuelCalculatorPresenterTest {

    private lateinit var viewMock: ManuelCalculatorContract.View
    private lateinit var presenter: ManuelCalculatorPresenter

    @Before
    fun setup() {
        viewMock = FrgManuelCalculator()
        presenter = ManuelCalculatorPresenter(viewMock)
    }

    @Test
    fun `add test`() {
        assertEquals(5, presenter.add(3, 2))
    }

    @Test
    fun `res test`() {
        assertEquals(6, presenter.res(10, 4))
    }

    @Test
    fun `mul test`() {
        assertEquals(60, presenter.mul(20, 3))
    }

    @Test
    fun `div test`() {
        assertEquals(3, presenter.div(9, 3))
    }
}
