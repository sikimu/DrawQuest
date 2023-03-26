package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.FillRectData

class RectEnemy {
    companion object {
        const val WIDTH = 100f
        const val HEIGHT = 100f
    }

    fun getRectData(center: Vector2D): FillRectData {
        return FillRectData(center.x - WIDTH / 2, center.y - HEIGHT / 2, WIDTH, HEIGHT, Color.BLACK)
    }
}