package com.sikimu.drawquest

data class GameMotionEvent(
    var vector2D : Vector2D,
    var action: Action
) {
    enum class Action {
        DOWN,
        UP,
        PRESS,
        FREE
    }
}

