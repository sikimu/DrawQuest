package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.RectPlayer
import com.sikimu.drawquest.drawdata.DrawPoint
import com.sikimu.drawquest.drawdata.DrawSize
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectPlayerDrawer {
    companion object{

        fun create(): FillCenterRectData {
            return FillCenterRectData(
                DrawPoint(0F,0F),
                DrawSize(RectPlayer.WIDTH , RectPlayer.HEIGHT),
                Color.BLUE)
        }
    }
}