package com.sikimu.drawquest

/**
 * ポイント(点)
 */
data class Point(var x: Float , var y: Float){
    /**
     * 位置と位置の計算結果はベクトルとする
     *
     * @param point 減算するポイント
     * @return 減算結果のベクトル
     */
    operator fun minus(point: Point): Vector2D {
        return Vector2D(x - point.x, y - point.y)
    }
}