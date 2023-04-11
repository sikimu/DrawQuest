package com.sikimu.drawquest

class HitData(val x: Float, val y: Float, val width: Float, val height: Float) {
    private val left = x
    private val right = x + width
    private val top = y
    private val bottom = y + height

    fun contains(event : GameMotionEvent) : Boolean {
        return event.vector2D.x in left..right && event.vector2D.y in top..bottom
    }
}