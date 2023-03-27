package com.sikimu.drawquest.drawdata

import com.sikimu.drawquest.Area

data class DrawAreaData(
    val x: DrawAreaParam ,
    val y: DrawAreaParam ,
    val width: DrawAreaParam ,
    val height: DrawAreaParam
)
{
    fun calcArea(screenWidth: Float , screenHeight: Float): Area {
        val x = when (val value = x) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val y = when (val value = y) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        val w = when (val value = width) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val h = when (val value = height) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        return Area(x, y, w, h)
    }
}

