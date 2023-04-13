package com.sikimu.drawquest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CollisionTest {
    @Test
    @DisplayName("HitDataのcontainsメソッドのテスト: HitData内にある点を引数に渡すとtrueを返す")
    fun testContains_returnsTrue_whenPointInsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        Assertions.assertTrue(Collision.contains(Point(100f, 100f), hitData))
        Assertions.assertTrue(Collision.contains(Point(100f, 300f), hitData))
        Assertions.assertTrue(Collision.contains(Point(300f, 100f), hitData))
        Assertions.assertTrue(Collision.contains(Point(300f, 300f), hitData))
    }

    @Test
    @DisplayName("HitDataのcontainsメソッドのテスト: HitData外にある点を引数に渡すとfalseを返す")
    fun testContains_returnsFalse_whenPointOutsideHitData() {
        val hitData = HitData(100f, 100f, 200f, 200f)
        // HitData外にある点のテスト
        Assertions.assertFalse(Collision.contains(Point(99.9f , 99.9f), hitData)) // 左上
        Assertions.assertFalse(Collision.contains(Point(200f , 99.9f), hitData)) // 上
        Assertions.assertFalse(Collision.contains(Point(300.1f , 99.9f), hitData)) // 右上
        Assertions.assertFalse(Collision.contains(Point(300.1f , 200f), hitData)) // 右
        Assertions.assertFalse(Collision.contains(Point(300.1f , 300.1f), hitData)) // 右下
        Assertions.assertFalse(Collision.contains(Point(200f , 300.1f), hitData)) // 下
        Assertions.assertFalse(Collision.contains(Point(99.9f , 300.1f), hitData)) // 左下
        Assertions.assertFalse(Collision.contains(Point(99.9f , 200f), hitData)) // 左
    }

}
