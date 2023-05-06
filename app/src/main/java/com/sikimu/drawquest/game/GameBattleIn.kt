package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawdata.*
import com.sikimu.drawquest.drawer.RectEnemyDrawer
import com.sikimu.drawquest.drawer.RectPlayerDrawer

/**
 * 戦闘開始時の暗転モード
 */
class GameBattleIn(worldData : WorldData): Game() {

    private var darkness = 0 // 矩形の暗さ (0: 透明, 255: 黒)
    private var fillRectData =
        FillCenterRectData(
            DrawPoint(0F,0F),
            DrawSize(DrawParam.ScreenW, DrawParam.ScreenH),
            Color.argb(darkness,0,0,0))

    private var enemyViewCenterX = DrawParam.Pixel(worldData.enemyCenter.x - worldData.cameraCenter.x)
    private var enemyViewCenterY = DrawParam.Pixel(worldData.enemyCenter.y - worldData.cameraCenter.y)

    override fun update(motionEvent: GameMotionEvent) : Game {
        darkness += 8 // 暗くする速度はここで調整する
        fillRectData = FillCenterRectData(
            DrawPoint(0F,0F),
            DrawSize(DrawParam.ScreenW, DrawParam.ScreenH),
            Color.argb(darkness % 256, 0, 0, 0))

        if (darkness >= 256 * 3) {
            // 暗さが255になったら次のモードに移行する
            return GameBattle()
        }
        return this
    }

    override fun createStorage(): DrawingDataStorage {
        val storage = DrawingDataStorage(Color.GREEN)
        storage.addRect(RectPlayerDrawer.create(DrawPoint(0F, 0F), Color.BLUE))
        storage.addRect(RectEnemyDrawer.create(DrawPoint(enemyViewCenterX, enemyViewCenterY)))
        storage.addRect(fillRectData)

        return storage
    }
}