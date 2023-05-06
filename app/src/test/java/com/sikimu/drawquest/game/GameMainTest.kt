package com.sikimu.drawquest.game

import com.sikimu.drawquest.RectPlayer
import com.sikimu.drawquest.Vector2D
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawer.RectEnemyDrawer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.math.abs

class GameMainTest {

    @Test
    fun testCreateStorage_returnsDrawingDataStorage() {
        // テスト対象のインスタンスを生成
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        // createStorage()で返されるDrawingDataStorageに含まれるRectDataの数を確認
        val result = gameMain.createStorage()
        assertNotNull(result.getStorage())
        assertEquals(2, result.getStorage().size)
    }

    @Test
    @DisplayName("左から接触")
    fun testHitBackLeft() {
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        worldData.playerCenter = Vector2D(50F, 250F)
        worldData.enemyCenter = Vector2D(100F, 250F)
        gameMain.hitBack()

        //縦横のどちらがか当たり判定からズレていればOK
        val result = worldData.playerCenter - worldData.enemyCenter
        //TODO エネミーの幅が不適切(現状移動先がない)
        //TODO 縦幅もない
        val resultX = abs(result.x) >= RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2
        val resultY = abs(result.y) >= RectPlayer.HEIGHT / 2 + RectEnemyDrawer.WIDTH / 2
        assertTrue(resultX || resultY)
    }

    @Test
    @DisplayName("右から接触")
    fun testHitBackRight() {
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        worldData.playerCenter = Vector2D(50F, 250F)
        worldData.enemyCenter = Vector2D(100F, 250F)
        gameMain.hitBack()

        //縦横のどちらがか当たり判定からズレていればOK
        val result = worldData.playerCenter - worldData.enemyCenter
        //TODO エネミーの幅が不適切(現状移動先がない)
        //TODO 縦幅もない
        val resultX = abs(result.x) >= RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2
        val resultY = abs(result.y) >= RectPlayer.HEIGHT / 2 + RectEnemyDrawer.WIDTH / 2
        assertTrue(resultX || resultY)
    }

    @Test
    @DisplayName("下から接触")
    fun testHitBackTop() {
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        worldData.playerCenter = Vector2D(50F, 250F)
        worldData.enemyCenter = Vector2D(50F, 200F)
        gameMain.hitBack()

        //縦横のどちらがか当たり判定からズレていればOK
        val result = worldData.playerCenter - worldData.enemyCenter
        //TODO エネミーの幅が不適切(現状移動先がない)
        //TODO 縦幅もない
        val resultX = abs(result.x) >= RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2
        val resultY = abs(result.y) >= RectPlayer.HEIGHT / 2 + RectEnemyDrawer.WIDTH / 2
        assertTrue(resultX || resultY)
    }

    @Test
    @DisplayName("上から接触")
    fun testHitBackBottom() {
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        worldData.playerCenter = Vector2D(50F, 150F)
        worldData.enemyCenter = Vector2D(50F, 200F)
        gameMain.hitBack()

        //縦横のどちらがか当たり判定からズレていればOK
        val result = worldData.playerCenter - worldData.enemyCenter
        //TODO エネミーの幅が不適切(現状移動先がない)
        //TODO 縦幅もない
        val resultX = abs(result.x) >= RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2
        val resultY = abs(result.y) >= RectPlayer.HEIGHT / 2 + RectEnemyDrawer.WIDTH / 2
        assertTrue(resultX || resultY)
    }

    @Test
    @DisplayName("右上から接触(今は中心からの距離でしか見ていないため重なりは残る)")
    fun testHitBackRightTop() {
        val worldData = WorldData()
        val gameMain = GameMain(worldData)

        worldData.playerCenter = Vector2D(50F, 150F)
        worldData.enemyCenter = Vector2D(100F, 200F)
        gameMain.hitBack()

        assertTrue((worldData.playerCenter - worldData.enemyCenter).magnitude() >= RectEnemyDrawer.WIDTH)
    }
}
