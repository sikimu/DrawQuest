package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.RectPlayer
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectPlayerDrawer {
    companion object{

        fun create(): FillCenterRectData {
            return FillCenterRectData(
                DrawAreaData(
                    0F,
                    0F,
                    RectPlayer.WIDTH , RectPlayer.HEIGHT
                ) ,
                Color.BLUE)
        }
    }
}