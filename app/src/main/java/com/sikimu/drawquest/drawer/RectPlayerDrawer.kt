package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.RectPlayer
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectPlayerDrawer {
    companion object{

        fun create(): FillCenterRectData {
            return FillCenterRectData(
                DrawAreaData(
                    DrawParam.ScreenW * 0.5F,
                    DrawParam.ScreenH * 0.5F,
                    RectPlayer.WIDTH , RectPlayer.HEIGHT
                ) ,
                Color.BLUE)
        }
    }
}