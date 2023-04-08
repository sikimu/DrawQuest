package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawer.RectEnemyDrawer
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillRectData

class GameBattleIn(val worldData : WorldData): Game() {

    private var darkness = 0 // 矩形の暗さ (0: 透明, 255: 黒)
    private var fillRectData : FillRectData = FillRectData(DrawAreaData(0F, 0F, 0F, 0F) , Color.argb(darkness,0,0,0))

    private var enemyViewCenterX = (DrawParam.ScreenW * 0.5F) + (worldData.enemyCenter.x - worldData.cameraCenter.x)
    private var enemyViewCenterY = (DrawParam.ScreenH * 0.5F) + (worldData.enemyCenter.y - worldData.cameraCenter.y)

    override fun update(motionEvent: GameMotionEvent) : Game {
        darkness += 8 // 暗くする速度はここで調整する
        fillRectData = FillRectData(DrawAreaData(0F, 0F, DrawParam.ScreenW, DrawParam.ScreenH) , Color.argb(darkness % 256, 0, 0, 0))

        if (darkness >= 256 * 3) {
            // 暗さが255になったら次のモードに移行する
            return GameBattle()
        }
        return this
    }

    override fun createStorage(): DrawingDataStorage {
        val storage = DrawingDataStorage(Color.GREEN)
        storage.addRect(worldData.player.getRectData())
        storage.addRect(RectEnemyDrawer.create(enemyViewCenterX, enemyViewCenterY))
        storage.addRect(fillRectData)

        return storage
    }
}