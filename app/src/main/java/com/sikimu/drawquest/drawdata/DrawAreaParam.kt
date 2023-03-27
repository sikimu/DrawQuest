package com.sikimu.drawquest.drawdata

sealed class DrawAreaParam {
    data class Pixel(val value: Float) : DrawAreaParam()
    data class Percent(val value: Float) : DrawAreaParam() {
        constructor(value: Int) : this(value.toFloat())
    }
}