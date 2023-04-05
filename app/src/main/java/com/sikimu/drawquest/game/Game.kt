package com.sikimu.drawquest.game

import com.sikimu.drawquest.DrawingDataStorage
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.WorldData

abstract class Game {
    abstract fun update(worldData : WorldData , motionEvent: GameMotionEvent) : Game
    abstract fun createStorage(worldData : WorldData): DrawingDataStorage
}