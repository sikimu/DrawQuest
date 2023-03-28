package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectEnemy {
    companion object {
        const val WIDTH = 100f
        const val HEIGHT = 100f
    }

    fun getRectData(center: Vector2D): FillCenterRectData {
        return FillCenterRectData(DrawAreaData(center.x, center.y, WIDTH, HEIGHT), Color.BLACK)
    }
}