package com.sikimu.drawquest.drawdata

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

/**
 * DrawAreaDataを使った矩形描画クラス
 */
data class StrokeCenterRectData(val drawAreaData : DrawAreaData , val color: Int , val strokeWidth: Float) : DrawData() {

    override fun draw(canvas : Canvas , paint : Paint) {
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth
        val area = drawAreaData.calcAreaCenter(canvas.width, canvas.height)
        val rect = RectF(area.left, area.top, area.right, area.bottom)
        canvas.drawRect(rect, paint) // rectListに格納された矩形を描画
    }
}
