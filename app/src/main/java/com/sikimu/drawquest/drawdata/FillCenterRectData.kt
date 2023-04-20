package com.sikimu.drawquest.drawdata

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

data class FillCenterRectData(val drawPoint : DrawPoint, val drawSize : DrawSize, val color: Int) : DrawData() {

    override fun draw(canvas : Canvas , paint : Paint) {
        paint.color = color
        paint.style = Paint.Style.FILL
        val area = DrawAreaCalculator.calcAreaCenter(drawPoint, drawSize, canvas.width, canvas.height)
        val rect = RectF(area.left, area.top, area.right, area.bottom)
        canvas.drawRect(rect, paint) // rectListに格納された矩形を描画
    }
}