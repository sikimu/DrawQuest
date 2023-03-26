package com.sikimu.drawquest

import com.sikimu.drawquest.game.Game
import com.sikimu.drawquest.game.GameTitle

class GameLoopController private constructor() {

    companion object {
        private var game: Game = GameTitle()

        fun update(system : GameSystem , motionEvent : GameMotionEvent): DrawingDataStorage {
            game = game.update(system, motionEvent)
            return game.createStorage()
        }
    }
}

