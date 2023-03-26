package com.sikimu.drawquest

class HitData(val left: Float , val top: Float , val right: Float , val bottom: Float) {

    fun contains(event: GameMotionEvent): Boolean {
        return event.vector2D.x in left..right && event.vector2D.y in top..bottom
    }
}
