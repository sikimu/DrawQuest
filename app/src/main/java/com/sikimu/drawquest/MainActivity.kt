package com.sikimu.drawquest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gameLoop: GameLoop
    private lateinit var mainView: MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        window.setDecorFitsSystemWindows(false)
        val controller = window.insetsController
        if (controller != null) {
            controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        mainView = findViewById(R.id.view) // mainView変数にMainViewのインスタンスを設定する

        gameLoop = GameLoop(GameHandler(mainView, Handler(Looper.getMainLooper()), 16))
    }

    override fun onResume() {
        super.onResume()
        gameLoop.start()
    }

    override fun onPause() {
        super.onPause()
        gameLoop.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        gameLoop.stop()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!gameLoop.onTouchEvent(event)) {
            return super.onTouchEvent(event)
        }
        return true
    }
}
