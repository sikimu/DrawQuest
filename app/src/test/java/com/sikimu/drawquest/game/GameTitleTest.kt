package com.sikimu.drawquest.game

import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.Point
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("GameTitleクラスのテスト")
class GameTitleTest {

    @Test
    @DisplayName("updateメソッドのテスト：motionEventがAction.UPの場合")
    fun testUpdate_returnsGameMain_whenMotionEventActionUp() {
        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()

        // クリック位置がクリック対象の中にある場合
        val result1 = gameTitle.update(GameMotionEvent(Point(0F, 500F) , GameMotionEvent.Action.UP))
        assertEquals(result1::class, GameMain::class)

        // クリック位置がクリック対象の外にある場合
        val result2 = gameTitle.update(GameMotionEvent(Point(0F, 800F), GameMotionEvent.Action.UP))
        assertEquals(result2::class, GameTitle::class)
    }


    @Test
    @DisplayName("updateメソッドのテスト：motionEventがAction.UP以外の場合")
    fun testUpdate_returnsGameTitle_whenMotionEventNotNull() {
        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()

        // MotionEvent.ACTION_UP以外の場合はGameTitleのインスタンスが返る
        val result = gameTitle.update(GameMotionEvent(Point(0F, 500F), GameMotionEvent.Action.DOWN))
        assertEquals(result::class, GameTitle::class)
    }
}
