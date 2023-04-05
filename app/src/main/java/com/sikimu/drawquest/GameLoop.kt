package com.sikimu.drawquest

import android.view.MotionEvent
import com.sikimu.drawquest.game.Game
import com.sikimu.drawquest.game.GameTitle

class GameLoop(private val system: GameHandler) : Runnable {
    val motionEvent = GameMotionEvent(Vector2D(0F,0F) , GameMotionEvent.Action.FREE)
    private var isRunning = false
    private var lastUpdateTime = System.currentTimeMillis()
    private var game: Game = GameTitle()
    private var worldData = WorldData()

    override fun run() {
        if (isRunning) {
            val currentTime = System.currentTimeMillis()
            val elapsedTime = currentTime - lastUpdateTime
            lastUpdateTime = currentTime

            // ゲームの状態を更新する処理を実装する
            // 経過時間をelapsedTimeで考慮して、1回分の更新を行う
            game = game.update(worldData, motionEvent)
            val rectStorage = game.createStorage(worldData)
            system.draw(rectStorage)

            //Downを解除する
            if (motionEvent.action == GameMotionEvent.Action.DOWN) {
                motionEvent.action = GameMotionEvent.Action.PRESS
            }

            system.postDelayed(this, elapsedTime)
        }
    }

    fun start() {
        if (!isRunning) {
            isRunning = true
            system.post(this)
        }
    }

    fun stop() {
        isRunning = false
        system.removeCallbacks(this)
    }

    fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                motionEvent.action = GameMotionEvent.Action.DOWN
                motionEvent.vector2D = Vector2D(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {
                motionEvent.action = GameMotionEvent.Action.UP
                motionEvent.vector2D = Vector2D(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                //DOWNだけは優先して認識
                if (motionEvent.action != GameMotionEvent.Action.DOWN) {
                    motionEvent.action = GameMotionEvent.Action.PRESS
                    motionEvent.vector2D = Vector2D(event.x, event.y)
                }
            }
        }
        return false
    }
}
