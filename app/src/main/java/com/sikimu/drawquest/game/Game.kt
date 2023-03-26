package com.sikimu.drawquest.game

import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.GameSystem

abstract class Game {
    abstract fun update(system : GameSystem , motionEvent: GameMotionEvent) : Game
    abstract fun createStorage(): DrawingDataStorage
}