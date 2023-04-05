package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillRectData

class GameTitle : Game(){

    private val button = HitData(100F, 500F, 600F, 600F)

    override fun update(worldData: WorldData , motionEvent: GameMotionEvent): Game {
        if(motionEvent.action == GameMotionEvent.Action.UP) {
            return GameMain(worldData, motionEvent)
        }
        return this
    }

    override fun createStorage(worldData: WorldData): DrawingDataStorage {
        return DrawingDataStorage(Color.YELLOW).apply {
            addRect(FillRectData(DrawAreaData(button.left, button.top, button.right - button.left, button.bottom - button.top) , Color.WHITE))
        }
    }
}