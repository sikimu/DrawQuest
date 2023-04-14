package com.sikimu.drawquest

data class GameMotionEvent(
    val point : Point,
    val action: Action
) {
    enum class Action {
        DOWN,
        UP,
        PRESS,
        FREE
    }
}

