package com.sikimu.drawquest

import android.os.Handler

class GameHandler(private val mainView: MainView , private val handler: Handler , private val updateInterval: Long) {

    fun draw(storage : DrawingDataStorage){
        mainView.draw(storage)
    }

    fun post(gameLoop : GameLoop){
        handler.post(gameLoop)
    }

    fun postDelayed(gameLoop : GameLoop , elapsedTime : Long){
        val delay = if (elapsedTime >= updateInterval) 0 else updateInterval - elapsedTime
        handler.postDelayed(gameLoop, delay)
    }

    fun removeCallbacks(gameLoop : GameLoop){
        handler.removeCallbacks(gameLoop)
    }
}