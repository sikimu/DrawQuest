package com.sikimu.drawquest

import android.view.MotionEvent
import com.sikimu.drawquest.game.DebugTitle
import com.sikimu.drawquest.game.Game
import com.sikimu.drawquest.game.GameTitle

class GameLoop(private val system: GameHandler) : Runnable {
    var motionEvent = GameMotionEvent(Point(0F,0F) , GameMotionEvent.Action.FREE)
    private var isRunning = false
    private var lastUpdateTime = System.currentTimeMillis()
    private var game: Game = if (BuildConfig.DEBUG) DebugTitle() else GameTitle()

    override fun run() {
        if (isRunning) {
            val currentTime = System.currentTimeMillis()
            val elapsedTime = currentTime - lastUpdateTime
            lastUpdateTime = currentTime

            // ゲームの状態を更新する処理を実装する
            // 経過時間をelapsedTimeで考慮して、1回分の更新を行う
            game = game.update(motionEvent)
            val rectStorage = game.createStorage()
            system.draw(rectStorage)

            //Downを解除する
            if (motionEvent.action == GameMotionEvent.Action.DOWN) {
                motionEvent = GameMotionEvent(motionEvent.point, GameMotionEvent.Action.PRESS)
            }
            //UPを解除する
            if (motionEvent.action == GameMotionEvent.Action.UP) {
                motionEvent = GameMotionEvent(motionEvent.point, GameMotionEvent.Action.FREE)
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

    fun onTouchEvent(event: MotionEvent, width: Int, height: Int): Boolean {

        // 画面の中心に原点を移動
        val point = Point(event.x - (width / 2), event.y - (height / 2))

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                motionEvent = GameMotionEvent(point, GameMotionEvent.Action.DOWN)
            }
            MotionEvent.ACTION_UP -> {
                motionEvent = GameMotionEvent(point, GameMotionEvent.Action.UP)
            }
            MotionEvent.ACTION_MOVE -> {
                //DOWNだけは優先して認識
                if (motionEvent.action != GameMotionEvent.Action.DOWN) {
                    motionEvent = GameMotionEvent(point, GameMotionEvent.Action.PRESS)
                }
            }
        }
        return false
    }
}
