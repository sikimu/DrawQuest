package com.sikimu.drawquest

import android.graphics.Color

class RectPlayer() {
    companion object {
        const val WIDTH = 100F
        const val HEIGHT = 100F

        const val VELOCITY = 20f // 速度
        const val MINIMUM_MOVE_DISTANCE = 100 // 最小移動距離
    }

    private var start: Point = Point(0F, 0F)
    private var delta: Vector2D = Vector2D(0F, 0F)

    private val color: ColorData = ColorData(0, 0, 255)

    fun update(motionEvent: GameMotionEvent) {
        when (motionEvent.action) {
            GameMotionEvent.Action.DOWN -> {
                // 開始点を記録
                start = motionEvent.point
            }
            GameMotionEvent.Action.PRESS -> {
                // 開始点からの移動量を計算
                val displacement = motionEvent.point - start
                val distance = displacement.magnitude()

                // 最小移動距離を超えた場合
                delta = if (distance >= MINIMUM_MOVE_DISTANCE) {
                    val velocity = VELOCITY // 速度
                    displacement.normalize() * velocity
                } else {
                    Vector2D(0f, 0f)
                }
            }
            else -> {
                delta = Vector2D(0f, 0f)
            }
        }
    }

    fun getColor(): Int {
        return Color.rgb(color.r, color.g, color.b)
    }

    fun getDelta(): Vector2D {
        return delta
    }
}