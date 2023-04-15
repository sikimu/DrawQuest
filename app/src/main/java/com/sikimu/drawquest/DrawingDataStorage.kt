package com.sikimu.drawquest

import android.graphics.Color
import com.sikimu.drawquest.drawdata.DrawData

class DrawingDataStorage(private var backgroundColor: Int = Color.WHITE) {

    private val rectList = ArrayList<DrawData>()

    fun addRect(rect: DrawData) {
        rectList.add(rect)
    }

    fun addRectAll(rectList: List<DrawData>) {
        this.rectList.addAll(rectList)
    }

    fun getStorage(): List<DrawData> {
        return rectList
    }

    fun getBackgroundColor(): Int {
        return backgroundColor
    }
}