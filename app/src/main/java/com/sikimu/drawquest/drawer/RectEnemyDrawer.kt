package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectEnemyDrawer {
    companion object {
        const val WIDTH = 100f
        const val HEIGHT = 100f

        fun create(x : DrawParam , y : DrawParam): FillCenterRectData {
            return FillCenterRectData(DrawAreaData(x, y, WIDTH, HEIGHT), Color.BLACK)
        }
    }
}