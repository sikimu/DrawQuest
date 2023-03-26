package com.sikimu.drawquest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MainView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var drawingDataStorage: DrawingDataStorage? = null
    private val paint = Paint() // Paintオブジェクトをフィールドに宣言

    @Synchronized
    fun draw(storage : DrawingDataStorage) {
        drawingDataStorage = storage
        invalidate() // 画面を再描画
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawingDataStorage?.let { canvas.drawColor(it.getBackgroundColor()) }

        canvas.save() // 描画状態を保存

        synchronized(this) {
            drawingDataStorage?.getStorage()?.forEach {
                it.draw(canvas, paint)
            }
        }

        canvas.restore() // 描画状態を復元
    }
}
