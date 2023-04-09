package com.sikimu.drawquest

import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import androidx.test.core.view.MotionEventBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameLoopTest {
    private val updateInterval: Long = 16 // 60 fps
    private lateinit var view: MainView

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        view = MainView(context, null)
    }

    @Test
    fun testOnTouchEvent_downAction() {
        // setup
        val gameLoop = GameLoop(GameHandler(view, Handler(Looper.getMainLooper()), updateInterval))
        val builder = MotionEventBuilder.newBuilder()
        builder.setPointer(100F,100F)
        builder.setAction(MotionEvent.ACTION_DOWN)
        val motionEvent = builder.build()

        // execute
        val result = gameLoop.onTouchEvent(motionEvent, 100, 100)

        // verify
        assertEquals(false, result)
        assertEquals(GameMotionEvent.Action.DOWN , gameLoop.motionEvent.action)
        assertEquals(50F, gameLoop.motionEvent.vector2D.x)
        assertEquals(50F, gameLoop.motionEvent.vector2D.y)

        // cleanup
        motionEvent.recycle()
    }

    @Test
    fun testOnTouchEvent_upAction() {
        // setup
        val gameLoop = GameLoop(GameHandler(view, Handler(Looper.getMainLooper()), updateInterval))
        val builder = MotionEventBuilder.newBuilder()
        builder.setAction(MotionEvent.ACTION_UP)
        builder.setPointer(150F,150F)
        val motionEvent = builder.build()

        // execute
        val result = gameLoop.onTouchEvent(motionEvent, 100, 100)

        // verify
        assertEquals(false, result)
        assertEquals(GameMotionEvent.Action.UP , gameLoop.motionEvent.action)
        assertEquals(100F, gameLoop.motionEvent.vector2D.x)
        assertEquals(100F, gameLoop.motionEvent.vector2D.y)

        // cleanup
        motionEvent.recycle()
    }

    @Test
    fun testOnTouchEvent_moveAction() {
        // setup
        val gameLoop = GameLoop(GameHandler(view, Handler(Looper.getMainLooper()), updateInterval))
        val builder = MotionEventBuilder.newBuilder()
        builder.setPointer(200F,200F)
        builder.setAction(MotionEvent.ACTION_MOVE)
        val motionEvent = builder.build()

        // execute
        val result = gameLoop.onTouchEvent(motionEvent, 100, 100)

        // verify
        assertEquals(false, result)
        assertEquals(GameMotionEvent.Action.PRESS , gameLoop.motionEvent.action)
        assertEquals(150F, gameLoop.motionEvent.vector2D.x)
        assertEquals(150F, gameLoop.motionEvent.vector2D.y)

        // cleanup
        motionEvent.recycle()
    }

    @Test
    fun testOnTouchEvent_downMoveUpAction() {
        // setup
        val gameLoop = GameLoop(GameHandler(view, Handler(Looper.getMainLooper()), updateInterval))
        val builder = MotionEventBuilder.newBuilder()
        builder.setPointer(100F,100F)
        builder.setAction(MotionEvent.ACTION_DOWN)
        val motionEvent = builder.build()

        // execute
        val result = gameLoop.onTouchEvent(motionEvent, 100, 100)

        // verify
        assertEquals(false, result)
        assertEquals(GameMotionEvent.Action.DOWN , gameLoop.motionEvent.action)
        assertEquals(50F, gameLoop.motionEvent.vector2D.x)
        assertEquals(50F, gameLoop.motionEvent.vector2D.y)

        builder.setPointer(110F,110F)
        builder.setAction(MotionEvent.ACTION_MOVE)
        assertEquals(GameMotionEvent.Action.DOWN , gameLoop.motionEvent.action)
        assertEquals(50F, gameLoop.motionEvent.vector2D.x)
        assertEquals(50F, gameLoop.motionEvent.vector2D.y)

        // cleanup
        motionEvent.recycle()
    }
}
