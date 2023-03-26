package com.sikimu.drawquest

import kotlin.math.sqrt

/**
 * 2次元ベクトルを表現するクラス。
 *
 * @property x ベクトルの x 成分
 * @property y ベクトルの y 成分
 */
data class Vector2D(var x: Float , var y: Float) {

    /**
     * 他のベクトルとの加算結果を返します。
     *
     * @param other 加算するベクトル
     * @return 加算結果のベクトル
     */
    operator fun plus(other: Vector2D): Vector2D {
        return Vector2D(x + other.x, y + other.y)
    }

    /**
     * 他のベクトルとの減算結果を返します。
     *
     * @param other 減算するベクトル
     * @return 減算結果のベクトル
     */
    operator fun minus(other: Vector2D): Vector2D {
        return Vector2D(x - other.x, y - other.y)
    }

    /**
     * スカラー倍した結果を返します。
     *
     * @param scalar スカラー
     * @return スカラー倍したベクトル
     */
    operator fun times(scalar: Float): Vector2D {
        return Vector2D(x * scalar, y * scalar)
    }

    /**
     * ベクトルの大きさを返します。
     *
     * @return ベクトルの大きさ
     */
    fun magnitude(): Float {
        return sqrt(x * x + y * y)
    }

    /**
     * 正規化したベクトルを返します。
     *
     * @return 正規化したベクトル
     */
    fun normalize(): Vector2D {
        val magnitude = magnitude()
        return Vector2D(x / magnitude, y / magnitude)
    }

    /**
     * 他のベクトルとの距離を返します。
     *
     * @param other 距離を測る対象のベクトル
     * @return 自身と対象のベクトルの距離
     */
    fun distanceTo(other: Vector2D): Float {
        return (this - other).magnitude()
    }
}
