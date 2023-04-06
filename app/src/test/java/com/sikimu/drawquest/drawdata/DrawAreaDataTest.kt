package com.sikimu.drawquest.drawdata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class DrawAreaDataTest{
    @Test
    fun `test DrawAreaData constructor with Pixels`() {
        val drawAreaData = DrawAreaData(
            x = DrawParam.Pixel(10f),
            y = DrawParam.Pixel(20f),
            width = DrawParam.Pixel(100f),
            height = DrawParam.Pixel(200f)
        )

        assertEquals(DrawParam.Pixel(10f), drawAreaData.x)
        assertEquals(DrawParam.Pixel(20f), drawAreaData.y)
        assertEquals(DrawParam.Pixel(100f), drawAreaData.width)
        assertEquals(DrawParam.Pixel(200f), drawAreaData.height)
    }

    @Test
    fun `toArea returns a valid Area for Pixel values`() {
        val drawAreaData = DrawAreaData(
            x = DrawParam.Pixel(50F),
            y = DrawParam.Pixel(50F),
            width = DrawParam.Pixel(100F),
            height = DrawParam.Pixel(200F)
        )
        val area = drawAreaData.calcArea(800, 600)
        assertEquals(50F, area.left)
        assertEquals(50F, area.top)
        assertEquals(150F, area.right)
        assertEquals(250F, area.bottom)
    }

    @Test
    fun testCreateDrawAreaDataPattern() {
        val pe = DrawParam.Pixel(25F)
        assertNotNull(pe)
        val ff = 10F

        var drawAreaData = DrawAreaData(pe, pe, pe, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, pe, pe, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, ff, pe, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, pe, ff, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, pe, pe, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, pe, ff, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, ff, pe, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, ff, ff, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, pe, pe, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, pe, ff, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, ff, pe, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(pe, ff, ff, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, pe, ff, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, ff, pe, ff)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, ff, ff, pe)
        assertNotNull(drawAreaData)
        drawAreaData = DrawAreaData(ff, ff, ff, ff)
        assertNotNull(drawAreaData)
    }

}