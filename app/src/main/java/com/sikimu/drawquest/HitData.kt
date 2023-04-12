package com.sikimu.drawquest

class HitData(val x: Float, val y: Float, val width: Float, val height: Float) {
    val left = x
    val right = x + width
    val top = y
    val bottom = y + height

    fun contains(event : GameMotionEvent) : Boolean {
        return event.vector2D.x in left..right && event.vector2D.y in top..bottom
    }
}