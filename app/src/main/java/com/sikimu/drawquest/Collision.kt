package com.sikimu.drawquest

/**
 * 重なり判定クラス
 */
class Collision {
    companion object{
        fun contains(point : Point, hitData : HitData) : Boolean {
            return point.x in hitData.left..hitData.right && point.y in hitData.top..hitData.bottom
        }
    }
}