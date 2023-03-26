package com.sikimu.drawquest.drawdata

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

data class FillRectData(var x: Float , var y: Float , val width: Float , val height: Float , val color: Int) : DrawData() {
    fun getCenterX() = x + width / 2
    fun getCenterY() = y + height / 2
    private fun getBottom() = y + height
    private fun getTop() = y
    private fun getLeft() = x
    private fun getRight() = x + width

    override fun draw(canvas : Canvas , paint : Paint) {
        paint.color = color
        paint.style = Paint.Style.FILL
        val rect = RectF(getLeft(), getTop(), getRight(), getBottom())
        canvas.drawRect(rect, paint) // rectListに格納された矩形を描画
    }
}