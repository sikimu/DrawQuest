package com.sikimu.drawquest.game

import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.Vector2D
import com.sikimu.drawquest.WorldData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class GameMainTest {

    @Test
    fun testCreateStorage_returnsDrawingDataStorage() {
        // テスト対象のインスタンスを生成
        val worldData = WorldData()
        val gameMain = GameMain(worldData, GameMotionEvent(Vector2D(150f, 550f) , GameMotionEvent.Action.DOWN))

        // createStorage()で返されるDrawingDataStorageに含まれるRectDataの数を確認
        val result = gameMain.createStorage(worldData)
        assertNotNull(result.getStorage())
        assertEquals(2, result.getStorage().size)
    }
}
