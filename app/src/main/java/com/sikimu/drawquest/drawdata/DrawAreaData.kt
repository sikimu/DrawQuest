package com.sikimu.drawquest.drawdata

import com.sikimu.drawquest.Area

data class DrawAreaData(
    val x: DrawAreaParam ,
    val y: DrawAreaParam ,
    val width: DrawAreaParam ,
    val height: DrawAreaParam
) {
    constructor(vararg params: Any): this(
        x = params.getOrNull(0)?.let {
            when (it) {
                is DrawAreaParam -> it
                is Float -> DrawAreaParam.Pixel(it)
                else -> null
            }
        } ?: throw IllegalArgumentException("x must be DrawAreaParam or Float"),
        y = params.getOrNull(1)?.let {
            when (it) {
                is DrawAreaParam -> it
                is Float -> DrawAreaParam.Pixel(it)
                else -> null
            }
        } ?: throw IllegalArgumentException("y must be DrawAreaParam or Float"),
        width = params.getOrNull(2)?.let {
            when (it) {
                is DrawAreaParam -> it
                is Float -> DrawAreaParam.Pixel(it)
                else -> null
            }
        } ?: throw IllegalArgumentException("width must be DrawAreaParam or Float"),
        height = params.getOrNull(3)?.let {
            when (it) {
                is DrawAreaParam -> it
                is Float -> DrawAreaParam.Pixel(it)
                else -> null
            }
        } ?: throw IllegalArgumentException("height must be DrawAreaParam or Float")
    )

    fun calcArea(screenWidth: Float , screenHeight: Float): Area {
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
        return Area(x, y, w, h)
    }
}
