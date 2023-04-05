package com.sikimu.drawquest

/**
 * 世界全体の情報
 */
class WorldData() {
    var cameraCenter = Vector2D(0F, 0F)

    var player = RectPlayer()
    var playerCenter = Vector2D(200F, 200F)
    var enemy = RectEnemy()
    var enemyCenter = Vector2D(200F, 400F)
}
