package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawer.RectEnemyDrawer
import com.sikimu.drawquest.drawdata.DrawParam

/**
 * ゲームのメインクラス
 *
 */
class GameMain(private val worldData : WorldData) : Game() {

    companion object{
        const val ENEMY_WINDOW_HEIGHT = 800F
        const val SELECT_WINDOW_HEIGHT = 400F
    }

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
        enemyViewCenterX = (DrawParam.ScreenW * 0.5F) + (worldData.enemyCenter.x - worldData.cameraCenter.x)
        enemyViewCenterY = (DrawParam.ScreenH * 0.5F) + (worldData.enemyCenter.y - worldData.cameraCenter.y)

        return this
    }

    /**
     * 描画データの作成
     *
     * @return 描画データ
     */
    override fun createStorage(): DrawingDataStorage {

        return DrawingDataStorage(Color.GREEN).apply {
            addRect(worldData.player.getRectData())
            addRect(RectEnemyDrawer.create(enemyViewCenterX, enemyViewCenterY))
        }
    }
}
