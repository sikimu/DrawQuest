package com.sikimu.drawquest

/**
 * 重なり判定クラス
 */
class Collision {
    companion object{
        fun contains(point : Point, hitData : HitData) : Boolean {
            return point.x in hitData.left..hitData.right && point.y in hitData.top..hitData.bottom
        }

        fun contains(point : Point, area : Area) : Boolean {
            return point.x in area.left..area.right && point.y in area.top..area.bottom
        }
    }
}