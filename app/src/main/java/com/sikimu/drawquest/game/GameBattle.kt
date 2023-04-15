package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.drawdata.*
import com.sikimu.drawquest.drawer.BattleDrawer
import com.sikimu.drawquest.drawer.RectEnemyDrawer

class GameBattle : Game() {

    //選択ウィンドウ
    private val selectWindow = StrokeRectData(
        DrawAreaData(
            -500F,
            400F,
            1000F,
            400F
        ) ,
        Color.WHITE,
        10F
    )

    override fun update(motionEvent: GameMotionEvent): Game {
        return this
    }

    override fun createStorage(): DrawingDataStorage {
        // ゲーム画面の四角形を含めた全ての四角形を返す
        val storage = DrawingDataStorage(Color.BLACK)
        storage.addRectAll(BattleDrawer.createEnemyWindow())
        storage.addRect(selectWindow)
        storage.addRect(RectEnemyDrawer.create(DrawParam.Pixel(0F), DrawParam.Pixel(-300F)))
        return storage
    }
}