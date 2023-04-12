package com.sikimu.drawquest

/**
 * 重なり判定クラス
 */
class Collision {
    companion object{
        fun contains(vector : Vector2D, hitData : HitData) : Boolean {
            return vector.x in hitData.left..hitData.right && vector.y in hitData.top..hitData.bottom
        }
    }
}