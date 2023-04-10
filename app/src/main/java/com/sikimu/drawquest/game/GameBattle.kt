package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.drawdata.*
import com.sikimu.drawquest.drawer.RectEnemyDrawer

class GameBattle : Game() {

    // 敵を表示する矩形の描画データ
    private val enemyWindow = StrokeRectData(
        DrawAreaData(
            -400F,
            -700F,
            800F,
            600F
        ) ,
        Color.WHITE,
        10F
    )

    // 敵ウィンドウの背景(空)
    private val enemySky = FillRectData(
        DrawAreaData(
            -400F,
            -700F,
            800F,
            200F
        ) ,
        Color.BLUE
    )

    //敵ウィンドウの背景(地上)
    private val enemyField = FillRectData(
        DrawAreaData(
            -400F,
            -500F,
            800F,
            400F
        ) ,
        Color.GREEN
    )

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
        storage.addRect(enemySky)
        storage.addRect(enemyField)
        storage.addRect(enemyWindow)
        storage.addRect(selectWindow)
        storage.addRect(RectEnemyDrawer.create(DrawParam.Pixel(0F), DrawParam.Pixel(-300F)))
        return storage
    }
}