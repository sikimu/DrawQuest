package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.FillCenterRectData

class RectPlayer {
    companion object {
        const val WIDTH = 100F
        const val HEIGHT = 100F
        const val VELOCITY = 20f // 速度
        const val MINIMUM_MOVE_DISTANCE = 100 // 最小移動距離
    }

    private var start: Vector2D = Vector2D(0F, 0F)
    private var delta: Vector2D = Vector2D(0F, 0F)

    fun update(motionEvent: GameMotionEvent) {
        when (motionEvent.action) {
            GameMotionEvent.Action.DOWN -> {
                // 開始点を記録
                start = motionEvent.vector2D
            }
            GameMotionEvent.Action.PRESS -> {
                // 開始点からの移動量を計算
                val displacement = motionEvent.vector2D - start
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

    fun getRectData(): FillCenterRectData {
        return FillCenterRectData(
            DrawAreaData(
                DrawParam.ScreenW * 0.5F,
                DrawParam.ScreenH * 0.5F,
                WIDTH , HEIGHT
            ),
            Color.BLUE)
    }

    fun getDelta(): Vector2D {
        return delta
    }
}