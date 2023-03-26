package com.sikimu.drawquest.drawdata

import android.graphics.Canvas
import android.graphics.Paint

abstract class DrawData() {
    abstract fun draw(canvas : Canvas , paint : Paint)
}