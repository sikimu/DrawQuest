package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectEnemy {
    companion object {
        const val WIDTH = 100f
        const val HEIGHT = 100f
    }

    fun getRectData(x : DrawParam, y : DrawParam): FillCenterRectData {
        return FillCenterRectData(DrawAreaData(x, y, WIDTH, HEIGHT), Color.BLACK)
    }
}