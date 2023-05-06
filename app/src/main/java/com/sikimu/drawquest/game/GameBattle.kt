package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.drawer.BattleDrawer

class GameBattle : Game() {
    override fun update(motionEvent: GameMotionEvent): Game {
        return this
    }

    override fun createStorage(): DrawingDataStorage {
        // ゲーム画面の四角形を含めた全ての四角形を返す
        val storage = DrawingDataStorage(Color.BLACK)
        storage.addRectAll(BattleDrawer.createEnemyWindow())
        storage.addRect(BattleDrawer.createSelectWindow())
        storage.addRectAll(BattleDrawer.createPlayerWindow())
        return storage
    }
}