package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawParam
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RectEnemyDrawerTest {

    @Test
    fun testGetRectData() {
        val rectData = RectEnemyDrawer.create(DrawParam.Pixel(50F), DrawParam.Pixel(100F))
        assertEquals(DrawParam.Pixel(50F), rectData.drawAreaData.x)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.y)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.width)
        assertEquals(DrawParam.Pixel(100F), rectData.drawAreaData.height)
        assertEquals(Color.BLACK, rectData.color)
    }
}