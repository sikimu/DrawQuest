package com.sikimu.drawquest.drawdata

data class DrawPoint(val x: DrawParam, val y: DrawParam){
    constructor(x: DrawParam, y: Float): this(x, DrawParam.Pixel(y))
    constructor(x: Float, y: DrawParam): this(DrawParam.Pixel(x), y)
    constructor(x: Float, y: Float): this(DrawParam.Pixel(x), DrawParam.Pixel(y))
}