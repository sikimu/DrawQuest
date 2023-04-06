package com.sikimu.drawquest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HitDataTest {

    @Test
    fun testContains_returnsTrue_whenPointInsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        // HitData内に含まれる点のテスト
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(100f, 100f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(100f, 200f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(200f, 100f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(200f, 200f), GameMotionEvent.Action.DOWN)))
    }

    @Test
    fun testContains_returnsFalse_whenPointOutsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        // HitData外にある点のテスト
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(99f, 99f), GameMotionEvent.Action.DOWN)))
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(201f, 201f), GameMotionEvent.Action.DOWN)))
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(200f, 99f), GameMotionEvent.Action.DOWN)))
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(99f, 200f), GameMotionEvent.Action.DOWN)))
    }
}
