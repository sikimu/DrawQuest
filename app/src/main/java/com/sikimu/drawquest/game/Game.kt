package com.sikimu.drawquest.game

import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent

abstract class Game {
    abstract fun update(motionEvent: GameMotionEvent) : Game
    abstract fun createStorage(): DrawingDataStorage
}