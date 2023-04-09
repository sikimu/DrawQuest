package com.sikimu.drawquest

class HitData(val centerX: Float, val centerY: Float, val width: Float, val height: Float) {
    private val left = centerX - height / 2
    private val right = centerX + height / 2
    private val top = centerY - width / 2
    private val bottom = centerY + width / 2

    fun contains(event : GameMotionEvent) : Boolean {
        return event.vector2D.x in left..right && event.vector2D.y in top..bottom
    }
}