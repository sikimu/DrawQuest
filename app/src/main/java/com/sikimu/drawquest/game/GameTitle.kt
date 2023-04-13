package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillRectData

class GameTitle : Game(){

    private val button =
        Area(-250F, 450F, 500F, 100F)

    override fun update(motionEvent: GameMotionEvent): Game {
        if(motionEvent.action == GameMotionEvent.Action.UP) {
            if(Collision.contains(motionEvent.point, button)) {
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