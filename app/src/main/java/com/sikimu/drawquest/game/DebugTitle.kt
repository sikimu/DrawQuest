package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawdata.DrawPoint
import com.sikimu.drawquest.drawdata.DrawSize
import com.sikimu.drawquest.drawdata.FillRectData

class DebugTitle : Game(){

    /**
     * タップエリア
     */
    private val tapArea =
        Area(-250F, 450F, 500F, 100F)

    /**
     * ボタン矩形
     */
    private val button = FillRectData(
        DrawPoint(-250F, 450F),
        DrawSize(500F, 100F), Color.WHITE)

    override fun update(motionEvent: GameMotionEvent): Game {
        if(motionEvent.action == GameMotionEvent.Action.UP) {
            if(Collision.contains(motionEvent.point, tapArea)) {
                return GameMain(WorldData())
            }
        }
        return this
    }

    /**
     * 描画データを作成する
     */
    override fun createStorage(): DrawingDataStorage {
        return DrawingDataStorage(Color.BLACK).apply {
            addRect(button)
        }
    }
}