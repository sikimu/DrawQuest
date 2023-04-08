package com.sikimu.drawquest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HitDataTest {

    @Test
    @DisplayName("HitDataのcontainsメソッドのテスト: HitData内にある点を引数に渡すとtrueを返す")
    fun testContains_returnsTrue_whenPointInsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        // HitData内に含まれる点のテスト
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(100f, 100f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(100f, 300f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(300f, 100f), GameMotionEvent.Action.DOWN)))
        assertTrue(hitData.contains(GameMotionEvent(Vector2D(300f, 300f), GameMotionEvent.Action.DOWN)))
    }

    @Test
    @DisplayName("HitDataのcontainsメソッドのテスト: HitData外にある点を引数に渡すとfalseを返す")
    fun testContains_returnsFalse_whenPointOutsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        // HitData外にある点のテスト
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(99.9f, 99.9f), GameMotionEvent.Action.DOWN))) // 左上
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(100.1f, 99.9f), GameMotionEvent.Action.DOWN))) // 上端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(99.9f, 100.1f), GameMotionEvent.Action.DOWN))) // 左端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(300.1f, 99.9f), GameMotionEvent.Action.DOWN))) // 上端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(300.1f, 100.1f), GameMotionEvent.Action.DOWN))) // 右上
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(350.1f, 99.9f), GameMotionEvent.Action.DOWN))) // 上端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(350.1f, 100.1f), GameMotionEvent.Action.DOWN))) // 右端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(99.9f, 300.1f), GameMotionEvent.Action.DOWN))) // 左下
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(100.1f, 300.1f), GameMotionEvent.Action.DOWN))) // 下端
        assertFalse(hitData.contains(GameMotionEvent(Vector2D(300.1f, 300.1f), GameMotionEvent.Action.DOWN))) // 右下
    }
}
