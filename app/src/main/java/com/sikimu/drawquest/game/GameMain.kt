package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawer.RectEnemyDrawer
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.DrawPoint
import com.sikimu.drawquest.drawer.RectPlayerDrawer

/**
 * ゲームのメインクラス
 *
 */
class GameMain(private val worldData : WorldData) : Game() {

    // 敵の表示位置
    private var enemyViewCenterX = (DrawParam.ScreenW * 0.5F) + (worldData.enemyCenter.x - worldData.cameraCenter.x)
    private var enemyViewCenterY = (DrawParam.ScreenH * 0.5F) + (worldData.enemyCenter.y - worldData.cameraCenter.y)

    /**
     * ゲームの状態を更新する
     *
     * @param motionEvent ゲームの入力
     * @return ゲームの状態
     */
    override fun update(motionEvent: GameMotionEvent): Game {

        worldData.player.update(motionEvent)

        worldData.playerCenter += worldData.player.getDelta()
        worldData.cameraCenter = worldData.playerCenter

        // プレイヤーと敵が近すぎる場合、プレイヤーの位置を調整する
        if ((worldData.playerCenter - worldData.enemyCenter).magnitude() < (RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2)) {
            worldData.playerCenter += ((worldData.playerCenter - worldData.enemyCenter).normalize() * (RectPlayer.WIDTH / 2 + RectEnemyDrawer.WIDTH / 2) - (worldData.playerCenter - worldData.enemyCenter))
            return GameBattleIn(worldData)
        }

        // 敵の表示位置を更新する
        enemyViewCenterX = DrawParam.Pixel(worldData.enemyCenter.x - worldData.cameraCenter.x)
        enemyViewCenterY = DrawParam.Pixel(worldData.enemyCenter.y - worldData.cameraCenter.y)

        return this
    }

    /**
     * 描画データの作成
     *
     * @return 描画データ
     */
    override fun createStorage(): DrawingDataStorage {

        return DrawingDataStorage(Color.GREEN).apply {
            addRect(RectPlayerDrawer.create())
            addRect(RectEnemyDrawer.create(DrawPoint(enemyViewCenterX, enemyViewCenterY)))
        }
    }
}
