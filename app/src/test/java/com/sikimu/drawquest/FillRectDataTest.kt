package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.FillRectData
import org.junit.Assert.*
import org.junit.Test

class FillRectDataTest {

    @Test
    fun `should set center correctly`() {
        val fillRectData = FillRectData(100.0F, 100.0F, 50.0F, 50.0F, 0)
        assertEquals(125.0F, fillRectData.getCenterX())
        assertEquals(125.0F, fillRectData.getCenterY())
    }

    @Test
    fun `should compare equal when all properties are the same`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)

        // Then
        assertEquals(fillRectData1, fillRectData2)
    }

    @Test
    fun `should compare not equal when centerX is different`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(200.0F, 200.0F, 50.0F, 80.0F, Color.RED)

        // Then
        assertNotEquals(fillRectData1, fillRectData2)
    }

    @Test
    fun `should compare not equal when centerY is different`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(100.0F, 300.0F, 50.0F, 80.0F, Color.RED)

        // Then
        assertNotEquals(fillRectData1, fillRectData2)
    }

    @Test
    fun `should compare not equal when width is different`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(100.0F, 200.0F, 70.0F, 80.0F, Color.RED)

        // Then
        assertNotEquals(fillRectData1, fillRectData2)
    }

    @Test
    fun `should compare not equal when height is different`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(100.0F, 200.0F, 50.0F, 100.0F, Color.RED)

        // Then
        assertNotEquals(fillRectData1, fillRectData2)
    }

    @Test
    fun `should compare not equal when color is different`() {
        // Given
        val fillRectData1 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.RED)
        val fillRectData2 = FillRectData(100.0F, 200.0F, 50.0F, 80.0F, Color.BLUE)

        // Then
        assertNotEquals(fillRectData1, fillRectData2)
    }
}
