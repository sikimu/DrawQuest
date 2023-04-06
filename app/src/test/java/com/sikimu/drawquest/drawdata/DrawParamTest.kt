package com.sikimu.drawquest.drawdata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class DrawParamTest {

    @Test
    fun calcPixel() {
        val pixel = DrawParam.Pixel(100f)
        assertEquals(100f, pixel.calc(1080, 1920))
    }

    @Test
    fun calcScreenW() {
        val screenW = DrawParam.ScreenW
        assertEquals(1080f, screenW.calc(1080, 1920))
    }

    @Test
    fun calcScreenH() {
        val screenH = DrawParam.ScreenH
        assertEquals(1920f, screenH.calc(1080, 1920))
    }

    @Test
    fun calcExpressionPlus() {
        val result = (DrawParam.Pixel(100f) + DrawParam.Pixel(50f) + 25f).calc(1080, 1920)
        assertEquals(175f, result)
    }

    @Test
    fun calcExpressionMinus() {
        val result = (DrawParam.Pixel(100f) - DrawParam.Pixel(50f) - 25f).calc(1080, 1920)
        assertEquals(25f, result)
    }

    @Test
    fun calcExpressionMultiply() {
        val result = (DrawParam.Pixel(100f) * DrawParam.Pixel(2f) * 2f).calc(1080, 1920)
        assertEquals(400f, result)
    }

    @Test
    fun calcExpressionDivide() {
        val result = (DrawParam.Pixel(100f) / DrawParam.Pixel(2f) / 2f).calc(1080, 1920)
        assertEquals(25f, result)
    }

}