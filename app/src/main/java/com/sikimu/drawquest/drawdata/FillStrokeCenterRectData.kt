package com.sikimu.drawquest.drawdata

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

data class FillStrokeCenterRectData(val drawPoint : DrawPoint , val drawSize : DrawSize , val fillColor: Int, val strokeColor: Int) : DrawData() {

    override fun draw(canvas : Canvas , paint : Paint) {
        paint.color = fillColor
        paint.style = Paint.Style.FILL
        val area = DrawAreaCalculator.calcAreaCenter(drawPoint, drawSize, canvas.width, canvas.height)
        val rect = RectF(area.left, area.top, area.right, area.bottom)
        canvas.drawRect(rect, paint) // rectListに格納された矩形を描画
        paint.color = strokeColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        canvas.drawRect(rect, paint)
    }
}