package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillRectData
import com.sikimu.drawquest.drawdata.StrokeRectData

class GameBattle(private val worldData: WorldData) : Game() {
    // 敵を表示する矩形の描画データ
    private val enemyWindow = StrokeRectData(
        DrawAreaData(
            DrawParam.ScreenW * 0.1F,
            DrawParam.ScreenH * 0.1F,
            DrawParam.ScreenW * 0.8F,
            GameMain.ENEMY_WINDOW_HEIGHT
        ) ,
        Color.WHITE,
        10F
    )

    // 敵ウィンドウの背景(空)
    private val enemySky = FillRectData(
        DrawAreaData(
            DrawParam.ScreenW * 0.1F,
            DrawParam.ScreenH * 0.1F,
            DrawParam.ScreenW * 0.8F,
            GameMain.ENEMY_WINDOW_HEIGHT * 0.3F
        ) ,
        Color.BLUE
    )

    //敵ウィンドウの背景(地上)
    private val enemyField = FillRectData(
        DrawAreaData(
            DrawParam.ScreenW * 0.1F,
            DrawParam.ScreenH * 0.1F + GameMain.ENEMY_WINDOW_HEIGHT * 0.3F,
            DrawParam.ScreenW * 0.8F,
            GameMain.ENEMY_WINDOW_HEIGHT * 0.7F
        ) ,
        Color.GREEN
    )

    //選択ウィンドウ
    private val selectWindow = StrokeRectData(
        DrawAreaData(
            DrawParam.ScreenW * 0.05F,
            DrawParam.ScreenH * 0.6F,
            DrawParam.ScreenW * 0.9F,
            GameMain.SELECT_WINDOW_HEIGHT
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
        storage.addRect(worldData.enemy.getRectData(DrawParam.ScreenW / 2F, DrawParam.ScreenH * 0.1F + GameMain.ENEMY_WINDOW_HEIGHT * 0.7F))

        return storage
    }
}