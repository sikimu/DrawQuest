package com.sikimu.drawquest

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class RectPlayerTest {

    @Test
    fun testRectPlayer_notMoving() {
        val player = RectPlayer()
        val motionEvent = GameMotionEvent(Point(0F,0F), GameMotionEvent.Action.UP)
        player.update(motionEvent)
        assertTrue(player.getDelta() == Vector2D(0F,0F))
    }

    @Test
    fun testRectPlayer_moving() {
        val player = RectPlayer()
        var motionEvent = GameMotionEvent(Point(100F,100F), GameMotionEvent.Action.DOWN)

        player.update(motionEvent)

        motionEvent = GameMotionEvent(Point(200F,200F), GameMotionEvent.Action.PRESS)

        player.update(motionEvent)

        assertTrue(player.getDelta().x > 0F)

        motionEvent = GameMotionEvent(Point(0F,0F), GameMotionEvent.Action.PRESS)
        player.update(motionEvent)

        assertTrue(player.getDelta().x < 0F)
    }
}