package com.sikimu.drawquest

data class GameMotionEvent(
    var point : Point,
    var action: Action
) {
    enum class Action {
        DOWN,
        UP,
        PRESS,
        FREE
    }
}

