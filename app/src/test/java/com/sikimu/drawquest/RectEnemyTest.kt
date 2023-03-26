package com.sikimu.drawquest

import android.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Test

class RectEnemyTest {

    @Test
    fun testGetRectData() {
        val enemy = RectEnemy()
        val rectData = enemy.getRectData(Vector2D(50F, 100F))
        assertEquals(0f, rectData.x)
        assertEquals(50f, rectData.y)
        assertEquals(100f, rectData.width)
        assertEquals(100f, rectData.height)
        assertEquals(Color.BLACK, rectData.color)
    }
}