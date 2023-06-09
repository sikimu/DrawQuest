package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.drawdata.*

class RectEnemyDrawer {
    companion object {
        const val WIDTH = 100f
        private const val HEIGHT = 100f

        fun create(point : DrawPoint): FillStrokeCenterRectData {
            return FillStrokeCenterRectData(point, DrawSize(WIDTH, HEIGHT) , Color.BLACK, Color.WHITE)
        }
    }
}