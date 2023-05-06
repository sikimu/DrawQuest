package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.RectPlayer
import com.sikimu.drawquest.drawdata.DrawPoint
import com.sikimu.drawquest.drawdata.DrawSize
import com.sikimu.drawquest.drawdata.FillStrokeCenterRectData

class RectPlayerDrawer {
    companion object{

        fun create(point: DrawPoint): FillStrokeCenterRectData {
            return FillStrokeCenterRectData(
                point,
                DrawSize(RectPlayer.WIDTH , RectPlayer.HEIGHT),
                Color.BLUE, Color.BLACK)
        }
    }
}