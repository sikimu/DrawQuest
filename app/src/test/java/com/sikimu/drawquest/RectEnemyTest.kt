package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawAreaParam
import org.junit.Assert.assertEquals
import org.junit.Test

class RectEnemyTest {

    @Test
    fun testGetRectData() {
        val enemy = RectEnemy()
        val rectData = enemy.getRectData(Vector2D(50F, 100F))
        assertEquals(DrawAreaParam.Pixel(50F), rectData.drawAreaData.x)
        assertEquals(DrawAreaParam.Pixel(100F), rectData.drawAreaData.y)
        assertEquals(DrawAreaParam.Pixel(100F), rectData.drawAreaData.width)
        assertEquals(DrawAreaParam.Pixel(100F), rectData.drawAreaData.height)
        assertEquals(Color.BLACK, rectData.color)
    }
}