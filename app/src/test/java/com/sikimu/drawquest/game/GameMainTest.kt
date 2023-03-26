package com.sikimu.drawquest.game

import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.GameSystem
import com.sikimu.drawquest.Vector2D
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito

class GameMainTest {

    @Test
    fun testGetViewCenter() {
        val gameSystem = Mockito.mock(GameSystem::class.java)
        Mockito.`when`(gameSystem.getViewWidth()).thenReturn(200)
        Mockito.`when`(gameSystem.getViewHeight()).thenReturn(400)

        val center = Vector2D(100F, 100F)
        val cameraCenter = Vector2D(200F, 200F)

        val expected = Vector2D(0F, 100F)

        val result = GameMain.getViewCenter(gameSystem, center, cameraCenter)

        assertEquals(expected, result)
    }

    @Test
    fun testCreateStorage_returnsDrawingDataStorage() {
        // テスト対象のインスタンスを生成
        val gameSystem = Mockito.mock(GameSystem::class.java)
        val gameMain = GameMain(gameSystem, GameMotionEvent(Vector2D(150f, 550f) , GameMotionEvent.Action.DOWN))

        // createStorage()で返されるDrawingDataStorageに含まれるRectDataの数を確認
        val result = gameMain.createStorage()
        assertNotNull(result.getStorage())
        assertEquals(2, result.getStorage().size)
    }
}
