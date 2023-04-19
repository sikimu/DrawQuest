package com.sikimu.drawquest.drawdata

import com.sikimu.drawquest.Area

data class DrawAreaData(
    val x: DrawParam ,
    val y: DrawParam ,
    val width: DrawParam ,
    val height: DrawParam
) {
    companion object{
        fun calcArea(drawAreaData : DrawAreaData, screenWidth : Int , screenHeight : Int): Area {
            val x = drawAreaData.x.calc(screenWidth, screenHeight)
            val y = drawAreaData.y.calc(screenWidth, screenHeight)
            val w = drawAreaData.width.calc(screenWidth, screenHeight)
            val h = drawAreaData.height.calc(screenWidth, screenHeight)
            return Area(x, y, w, h)
        }
        /**
         * 中央に合わせて座標出力
         */
        fun calcAreaCenter(drawAreaData : DrawAreaData, screenWidth : Int , screenHeight : Int): Area {
            val x = drawAreaData.x.calc(screenWidth, screenHeight)
            val y = drawAreaData.y.calc(screenWidth, screenHeight)
            val w = drawAreaData.width.calc(screenWidth, screenHeight)
            val h = drawAreaData.height.calc(screenWidth, screenHeight)
            return Area(x - (w / 2), y - (h / 2), w, h)
        }
    }

    constructor(x: Float, y: Float, width: Float, height: Float): this(
        x = DrawParam.Pixel(x),
        y = DrawParam.Pixel(y),
        width = DrawParam.Pixel(width),
        height = DrawParam.Pixel(height)
    )
    constructor(x: DrawParam , y: Float , width: Float , height: Float): this(
        x = x,
        y = DrawParam.Pixel(y),
        width = DrawParam.Pixel(width),
        height = DrawParam.Pixel(height)
    )
    constructor(x: Float , y: DrawParam , width: Float , height: Float): this(
        x = DrawParam.Pixel(x),
        y = y,
        width = DrawParam.Pixel(width),
        height = DrawParam.Pixel(height)
    )
    constructor(x: Float , y: Float , width: DrawParam , height: Float): this(
        x = DrawParam.Pixel(x),
        y = DrawParam.Pixel(y),
        width = width,
        height = DrawParam.Pixel(height)
    )
    constructor(x: Float, y: Float, width: Float, height: DrawParam): this(
        x = DrawParam.Pixel(x),
        y = DrawParam.Pixel(y),
        width = DrawParam.Pixel(width),
        height = height
    )
    constructor(x: DrawParam , y: DrawParam , width: Float , height: Float): this(
        x = x,
        y = y,
        width = DrawParam.Pixel(width),
        height = DrawParam.Pixel(height)
    )
    constructor(x: DrawParam , y: Float , width: DrawParam , height: Float): this(
        x = x,
        y = DrawParam.Pixel(y),
        width = width,
        height = DrawParam.Pixel(height)
    )
    constructor(x: DrawParam , y: Float , width: Float , height: DrawParam): this(
        x = x,
        y = DrawParam.Pixel(y),
        width = DrawParam.Pixel(width),
        height = height
    )
    constructor(x: Float , y: DrawParam , width: DrawParam , height: Float): this(
        x = DrawParam.Pixel(x),
        y = y,
        width = width,
        height = DrawParam.Pixel(height)
    )
    constructor(x: Float , y: DrawParam , width: Float , height: DrawParam): this(
        x = DrawParam.Pixel(x),
        y = y,
        width = DrawParam.Pixel(width),
        height = height
    )
    constructor(x: Float , y: Float , width: DrawParam , height: DrawParam): this(
        x = DrawParam.Pixel(x),
        y = DrawParam.Pixel(y),
        width = width,
        height = height
    )
    constructor(x: DrawParam , y: DrawParam , width: DrawParam , height: Float): this(
        x = x,
        y = y,
        width = width,
        height = DrawParam.Pixel(height)
    )
    constructor(x: DrawParam , y: DrawParam , width: Float , height: DrawParam): this(
        x = x,
        y = y,
        width = DrawParam.Pixel(width),
        height = height
    )
    constructor(x: DrawParam , y: Float , width: DrawParam , height: DrawParam): this(
        x = x,
        y = DrawParam.Pixel(y),
        width = width,
        height = height
    )
    constructor(x: Float , y: DrawParam , width: DrawParam , height: DrawParam): this(
        x = DrawParam.Pixel(x),
        y = y,
        width = width,
        height = height
    )
}
