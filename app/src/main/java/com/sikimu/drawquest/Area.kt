package com.sikimu.drawquest

data class Area(val x: Float, val y: Float, val width: Float, val height: Float){
    val left = x
    val right = x + width
    val top = y
    val bottom = y + height
}
