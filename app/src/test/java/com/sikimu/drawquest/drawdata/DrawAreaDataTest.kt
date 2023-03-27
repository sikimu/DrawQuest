package com.sikimu.drawquest.drawdata

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

internal class DrawAreaDataTest{
    @Test
    fun `test DrawAreaData constructor with Pixels`() {
        val drawAreaData = DrawAreaData(
            x = DrawAreaParam.Pixel(10f),
            y = DrawAreaParam.Pixel(20f),
            width = DrawAreaParam.Pixel(100f),
            height = DrawAreaParam.Pixel(200f)
        )

        assertEquals(DrawAreaParam.Pixel(10f), drawAreaData.x)
        assertEquals(DrawAreaParam.Pixel(20f), drawAreaData.y)
        assertEquals(DrawAreaParam.Pixel(100f), drawAreaData.width)
        assertEquals(DrawAreaParam.Pixel(200f), drawAreaData.height)
    }

    @Test
    fun `test DrawAreaData constructor with Percents`() {
        val drawAreaData = DrawAreaData(
            x = DrawAreaParam.Percent(10),
            y = DrawAreaParam.Percent(10),
            width = DrawAreaParam.Percent(75f),
            height = DrawAreaParam.Percent(10f)
        )

        assertEquals(DrawAreaParam.Percent(10), drawAreaData.x)
        assertEquals(DrawAreaParam.Percent(10), drawAreaData.y)
        assertEquals(DrawAreaParam.Percent(75f), drawAreaData.width)
        assertEquals(DrawAreaParam.Percent(10f), drawAreaData.height)
    }

    @Test
    fun `toArea returns a valid Area for Pixel values`() {
        val drawAreaData = DrawAreaData(
            x = DrawAreaParam.Pixel(50F),
            y = DrawAreaParam.Pixel(50F),
            width = DrawAreaParam.Pixel(100F),
            height = DrawAreaParam.Pixel(200F)
        )
        val area = drawAreaData.calcArea(800F, 600F)
        assertEquals(50F, area.x)
        assertEquals(50F, area.y)
        assertEquals(100F, area.width)
        assertEquals(200F, area.height)
    }

    @Test
    fun `toArea returns a valid Area for Percent values`() {
        val drawAreaData = DrawAreaData(
            x = DrawAreaParam.Percent(25F),
            y = DrawAreaParam.Percent(50F),
            width = DrawAreaParam.Percent(50F),
            height = DrawAreaParam.Percent(25F)
        )
        val area = drawAreaData.calcArea(800F, 600F)
        assertEquals(200F, area.x)
        assertEquals(300F, area.y)
        assertEquals(400F, area.width)
        assertEquals(150F, area.height)
    }

    @Test
    fun testCreateDrawAreaDataPattern() {
        val pe = DrawAreaParam.Percent(25F)
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