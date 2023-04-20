package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.drawdata.*

class RectEnemyDrawer {
    companion object {
        const val WIDTH = 100f
        private const val HEIGHT = 100f

        fun create(x : DrawParam , y : DrawParam): FillCenterRectData {
            return FillCenterRectData(DrawPoint(x, y), DrawSize(WIDTH, HEIGHT) , Color.BLACK)
        }
    }
}