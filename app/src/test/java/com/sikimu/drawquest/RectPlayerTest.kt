package com.sikimu.drawquest

import android.graphics.Color
import org.junit.Test
import org.junit.Assert.*

class RectPlayerTest {

    @Test
    fun testRectPlayer_notMoving() {
        val player = RectPlayer()
        val motionEvent = GameMotionEvent(Vector2D(0F,0F), GameMotionEvent.Action.UP)
        player.update(motionEvent)
        assertTrue(player.getDelta() == Vector2D(0F,0F))
    }

    @Test
    fun testRectPlayer_moving() {
        val player = RectPlayer()
        val motionEvent = GameMotionEvent(Vector2D(100F,100F), GameMotionEvent.Action.DOWN)

        player.update(motionEvent)

        motionEvent.vector2D = Vector2D(200F,200F)
        motionEvent.action = GameMotionEvent.Action.PRESS
        player.update(motionEvent)

        assertTrue(player.getDelta().x > 0F)

        motionEvent.vector2D = Vector2D(0F,0F)
        motionEvent.action = GameMotionEvent.Action.PRESS
        player.update(motionEvent)

        assertTrue(player.getDelta().x < 0F)
    }
}