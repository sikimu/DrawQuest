package com.sikimu.drawquest.drawdata

data class DrawSize(val width: DrawParam, val height: DrawParam){
    constructor(width: DrawParam, height: Float): this(width, DrawParam.Pixel(height))
    constructor(width: Float, height: DrawParam): this(DrawParam.Pixel(width), height)
    constructor(width: Float, height: Float): this(DrawParam.Pixel(width), DrawParam.Pixel(height))
}
