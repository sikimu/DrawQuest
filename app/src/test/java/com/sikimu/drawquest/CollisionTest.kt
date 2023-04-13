package com.sikimu.drawquest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CollisionTest {
    @Test
    @DisplayName("Areaのcontainsメソッドのテスト: Area内にある点を引数に渡すとtrueを返す")
    fun testContains_returnsTrue_whenPointInsideArea() {
        val area = Area(100f, 100f, 200f, 200f)
        Assertions.assertTrue(Collision.contains(Point(100f, 100f), area))
        Assertions.assertTrue(Collision.contains(Point(100f, 300f), area))
        Assertions.assertTrue(Collision.contains(Point(300f, 100f), area))
        Assertions.assertTrue(Collision.contains(Point(300f, 300f), area))
    }

    @Test
    @DisplayName("Areaのcontainsメソッドのテスト: Area外にある点を引数に渡すとfalseを返す")
    fun testContains_returnsFalse_whenPointOutsideArea() {
        val area = Area(100f, 100f, 200f, 200f)
        // Area外にある点のテスト
        Assertions.assertFalse(Collision.contains(Point(99.9f , 99.9f), area)) // 左上
        Assertions.assertFalse(Collision.contains(Point(200f , 99.9f), area)) // 上
        Assertions.assertFalse(Collision.contains(Point(300.1f , 99.9f), area)) // 右上
        Assertions.assertFalse(Collision.contains(Point(300.1f , 200f), area)) // 右
        Assertions.assertFalse(Collision.contains(Point(300.1f , 300.1f), area)) // 右下
        Assertions.assertFalse(Collision.contains(Point(200f , 300.1f), area)) // 下
        Assertions.assertFalse(Collision.contains(Point(99.9f , 300.1f), area)) // 左下
        Assertions.assertFalse(Collision.contains(Point(99.9f , 200f), area)) // 左
    }
}
