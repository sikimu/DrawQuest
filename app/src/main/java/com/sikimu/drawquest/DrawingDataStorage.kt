package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawData

class DrawingDataStorage(private var backgroundColor: Int = Color.WHITE) {

    private val rectList = ArrayList<DrawData>()

    fun addRect(rect: DrawData) {
        rectList.add(rect)
    }

    fun removeRect(rect: DrawData) {
        rectList.remove(rect)
    }

    fun clearStorage() {
        rectList.clear()
    }

    fun getStorage(): List<DrawData> {
        return rectList
    }

    fun setBackgroundColor(color: Int) {
        backgroundColor = color
    }

    fun getBackgroundColor(): Int {
        return backgroundColor
    }
}