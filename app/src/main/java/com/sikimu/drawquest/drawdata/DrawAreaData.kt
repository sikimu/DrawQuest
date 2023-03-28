package com.sikimu.drawquest.drawdata

import com.sikimu.drawquest.Area

data class DrawAreaData(
    val x: DrawAreaParam ,
    val y: DrawAreaParam ,
    val width: DrawAreaParam ,
    val height: DrawAreaParam
) {
    constructor(x: Float, y: Float, width: Float, height: Float): this(
        x = DrawAreaParam.Pixel(x),
        y = DrawAreaParam.Pixel(y),
        width = DrawAreaParam.Pixel(width),
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: DrawAreaParam, y: Float, width: Float, height: Float): this(
        x = x,
        y = DrawAreaParam.Pixel(y),
        width = DrawAreaParam.Pixel(width),
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: Float, y: DrawAreaParam, width: Float, height: Float): this(
        x = DrawAreaParam.Pixel(x),
        y = y,
        width = DrawAreaParam.Pixel(width),
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: Float, y: Float, width: DrawAreaParam, height: Float): this(
        x = DrawAreaParam.Pixel(x),
        y = DrawAreaParam.Pixel(y),
        width = width,
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: Float, y: Float, width: Float, height: DrawAreaParam): this(
        x = DrawAreaParam.Pixel(x),
        y = DrawAreaParam.Pixel(y),
        width = DrawAreaParam.Pixel(width),
        height = height
    )
    constructor(x: DrawAreaParam, y: DrawAreaParam, width: Float, height: Float): this(
        x = x,
        y = y,
        width = DrawAreaParam.Pixel(width),
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: DrawAreaParam, y: Float, width: DrawAreaParam, height: Float): this(
        x = x,
        y = DrawAreaParam.Pixel(y),
        width = width,
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: DrawAreaParam, y: Float, width: Float, height: DrawAreaParam): this(
        x = x,
        y = DrawAreaParam.Pixel(y),
        width = DrawAreaParam.Pixel(width),
        height = height
    )
    constructor(x: Float, y: DrawAreaParam, width: DrawAreaParam, height: Float): this(
        x = DrawAreaParam.Pixel(x),
        y = y,
        width = width,
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: Float, y: DrawAreaParam, width: Float, height: DrawAreaParam): this(
        x = DrawAreaParam.Pixel(x),
        y = y,
        width = DrawAreaParam.Pixel(width),
        height = height
    )
    constructor(x: Float, y: Float, width: DrawAreaParam, height: DrawAreaParam): this(
        x = DrawAreaParam.Pixel(x),
        y = DrawAreaParam.Pixel(y),
        width = width,
        height = height
    )
    constructor(x: DrawAreaParam, y: DrawAreaParam, width: DrawAreaParam, height: Float): this(
        x = x,
        y = y,
        width = width,
        height = DrawAreaParam.Pixel(height)
    )
    constructor(x: DrawAreaParam, y: DrawAreaParam, width: Float, height: DrawAreaParam): this(
        x = x,
        y = y,
        width = DrawAreaParam.Pixel(width),
        height = height
    )
    constructor(x: DrawAreaParam, y: Float, width: DrawAreaParam, height: DrawAreaParam): this(
        x = x,
        y = DrawAreaParam.Pixel(y),
        width = width,
        height = height
    )
    constructor(x: Float, y: DrawAreaParam, width: DrawAreaParam, height: DrawAreaParam): this(
        x = DrawAreaParam.Pixel(x),
        y = y,
        width = width,
        height = height
    )

    fun calcArea(screenWidth : Int , screenHeight : Int): Area {
        val x = when (val value = x) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val y = when (val value = y) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        val w = when (val value = width) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val h = when (val value = height) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        return Area(x, y, x + w, y + h)
    }

    /**
     * 中央に合わせて座標出力
     */
    fun calcAreaCenter(screenWidth : Int , screenHeight : Int): Area {
        val x = when (val value = x) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val y = when (val value = y) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        val w = when (val value = width) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenWidth / 100.0F
        }
        val h = when (val value = height) {
            is DrawAreaParam.Pixel -> value.value
            is DrawAreaParam.Percent -> value.value * screenHeight / 100.0F
        }
        return Area(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2))
    }
}
