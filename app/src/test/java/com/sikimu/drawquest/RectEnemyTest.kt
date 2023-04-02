package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawParam
import org.junit.Assert.assertEquals
import org.junit.Test

class RectEnemyTest {

    @Test
    fun testGetRectData() {
        val enemy = RectEnemy()
        val rectData = enemy.getRectData(DrawParam.Pixel(50F), DrawParam.Pixel(100F))
        assertEquals(DrawParam.Pixel(50F), rectData.drawAreaData.x)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.y)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.width)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.height)
        assertEquals(Color.BLACK, rectData.color)
    }
}