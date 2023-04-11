package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.HitData
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillRectData

class GameTitle : Game(){

    private val button =
        HitData(-250F, 450F, 500F, 100F)

    override fun update(motionEvent: GameMotionEvent): Game {
        if(motionEvent.action == GameMotionEvent.Action.UP) {
            if(button.contains(motionEvent)) {
                return GameMain(WorldData())
            }
        }
        return this
    }

    override fun createStorage(): DrawingDataStorage {
        return DrawingDataStorage(Color.YELLOW).apply {
            addRect(FillRectData(DrawAreaData(button.x, button.y, button.width, button.height) , Color.WHITE))
        }
    }
}