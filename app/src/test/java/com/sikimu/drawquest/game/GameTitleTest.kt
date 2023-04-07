package com.sikimu.drawquest.game

import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.Vector2D
import com.sikimu.drawquest.WorldData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("GameTitleクラスのテスト")
class GameTitleTest {

    @Test
    @DisplayName("updateメソッドのテスト：motionEventがAction.UPの場合")
    fun testUpdate_returnsGameMain_whenMotionEventActionUp() {
        // テスト対象のインスタンスを生成
        val worldData = WorldData()
        val gameTitle = GameTitle()

        // クリック位置がクリック対象の中にある場合
        val result1 = gameTitle.update(worldData, GameMotionEvent(Vector2D(50f, 550f), GameMotionEvent.Action.UP))
        assertEquals(result1::class, GameTitle::class)

        // クリック位置がクリック対象の外にある場合
        val result2 = gameTitle.update(worldData, GameMotionEvent(Vector2D(700f, 550f), GameMotionEvent.Action.UP))
        assertEquals(result2::class, GameTitle::class)

        val result3 = gameTitle.update(worldData, GameMotionEvent(Vector2D(50f, 50f), GameMotionEvent.Action.UP))
        assertEquals(result3::class, GameTitle::class)

        val result4 = gameTitle.update(worldData, GameMotionEvent(Vector2D(50f, 700f), GameMotionEvent.Action.UP))
        assertEquals(result4::class, GameTitle::class)

        val result5 = gameTitle.update(worldData, GameMotionEvent(Vector2D(700f, 700f), GameMotionEvent.Action.UP))
        assertEquals(result5::class, GameTitle::class)
    }


    @Test
    @DisplayName("updateメソッドのテスト：motionEventがAction.UP以外の場合")
    fun testUpdate_returnsGameTitle_whenMotionEventNotNull() {
        // テスト対象のインスタンスを生成
        val worldData = WorldData()
        val gameTitle = GameTitle()

        // MotionEvent.ACTION_UP以外の場合はGameTitleのインスタンスが返る
        val result = gameTitle.update(worldData, GameMotionEvent(Vector2D(150f, 550f), GameMotionEvent.Action.DOWN))
        assertEquals(result::class, GameTitle::class)
    }
}
