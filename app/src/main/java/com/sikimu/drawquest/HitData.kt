package com.sikimu.drawquest

class HitData(val x: Float, val y: Float, val width: Float, val height: Float) {
    fun contains(event : GameMotionEvent) : Boolean {
        return event.vector2D.x in x..(x + width) && event.vector2D.y in y..(y + height)
    }
}