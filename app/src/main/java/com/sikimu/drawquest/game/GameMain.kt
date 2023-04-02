package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.DrawParam
import com.sikimu.drawquest.drawdata.StrokeRectData
import com.sikimu.drawquest.drawdata.FillRectData

/**
 * ゲームのメインクラス
 *
 * @param system ゲームのシステム
 * @param motionEvent ゲームの入力
 */
class GameMain(system: GameSystem, motionEvent: GameMotionEvent) : Game() {

    companion object{
        const val ENEMY_WINDOW_HEIGHT = 800F
        const val SELECT_WINDOW_HEIGHT = 400F
    }

    /** カメラ中央位置 */
    private var cameraCenter = Vector2D(0F, 0F)

    private val player = RectPlayer()
    private var playerCenter = Vector2D(200F, 200F)
    private val enemy = RectEnemy()
    private var enemyCenter = Vector2D(200F, 400F)

    // プレイヤーと敵の表示位置
    private var enemyViewCenterX = (DrawParam.ScreenW * 0.5F) + (enemyCenter.x - cameraCenter.x)
    private var enemyViewCenterY = (DrawParam.ScreenH * 0.5F) + (enemyCenter.y - cameraCenter.y)

    private var mode : Mode = Field()

    init {
        update(system, motionEvent)
    }

    /**
     * ゲームの状態を更新する
     *
     * @param system ゲームのシステム
     * @param motionEvent ゲームの入力
     * @return ゲームの状態
     */
    override fun update(system: GameSystem, motionEvent: GameMotionEvent): Game {

        mode = mode.update(system, motionEvent)

        return this
    }

    /**
     * 描画データの作成
     *
     * @return 描画データ
     */
    override fun createStorage(): DrawingDataStorage {
        return mode.createStorage()
    }

    abstract inner class Mode {
        abstract fun update(system : GameSystem , motionEvent: GameMotionEvent) : Mode
        abstract fun createStorage(): DrawingDataStorage
    }

    inner class Field : Mode() {

        override fun update(system: GameSystem , motionEvent: GameMotionEvent): Mode {

            var nextMode : Mode = this

            player.update(motionEvent)

            playerCenter += player.getDelta()
            cameraCenter = playerCenter

            // プレイヤーと敵が近すぎる場合、プレイヤーの位置を調整する
            if ((playerCenter - enemyCenter).magnitude() < (RectPlayer.WIDTH / 2 + RectEnemy.WIDTH / 2)) {
                playerCenter += ((playerCenter - enemyCenter).normalize() * (RectPlayer.WIDTH / 2 + RectEnemy.WIDTH / 2) - (playerCenter - enemyCenter))
                nextMode = BattleIn()
            }


            enemyViewCenterX = (DrawParam.ScreenW * 0.5F) + (enemyCenter.x - cameraCenter.x)
            enemyViewCenterY = (DrawParam.ScreenH * 0.5F) + (enemyCenter.y - cameraCenter.y)

            return nextMode
        }

        /**
         * 描画データの作成
         *
         * @return 描画データ
         */
        override fun createStorage(): DrawingDataStorage {
            return DrawingDataStorage(Color.GREEN).apply {
                addRect(player.getRectData())
                addRect(enemy.getRectData(enemyViewCenterX, enemyViewCenterY))
            }
        }
    }

    inner class BattleIn : Mode() {
        private var darkness = 0 // 矩形の暗さ (0: 透明, 255: 黒)
        private var fillRectData : FillRectData = FillRectData(DrawAreaData(0F, 0F, 0F, 0F) , Color.argb(darkness,0,0,0))

        override fun update(system: GameSystem , motionEvent: GameMotionEvent): Mode {
            darkness += 8 // 暗くする速度はここで調整する
            fillRectData = FillRectData(DrawAreaData(0F, 0F, system.getViewWidth().toFloat(), system.getViewHeight().toFloat()), Color.argb(darkness % 256, 0, 0, 0))
            if (darkness >= 256 * 3) {
                // 暗さが255になったら次のモードに移行する
                return Battle()
            }
            return this
        }

        override fun createStorage(): DrawingDataStorage {
            val storage = DrawingDataStorage(Color.GREEN)
            storage.addRect(player.getRectData())
            storage.addRect(enemy.getRectData(enemyViewCenterX, enemyViewCenterY))
            storage.addRect(fillRectData)

            return storage
        }
    }

    inner class Battle() : Mode() {

        // 敵を表示する矩形の描画データ
        private val enemyWindow = StrokeRectData(
            DrawAreaData(
                DrawParam.ScreenW * 0.1F,
                DrawParam.ScreenH * 0.1F,
                DrawParam.ScreenW * 0.8F,
                ENEMY_WINDOW_HEIGHT
            ),
            Color.WHITE,
            10F
        )

        // 敵ウィンドウの背景(空)
        private val enemySky = FillRectData(
            DrawAreaData(
                DrawParam.ScreenW * 0.1F,
                DrawParam.ScreenH * 0.1F,
                DrawParam.ScreenW * 0.8F,
                ENEMY_WINDOW_HEIGHT * 0.3F
            ),
            Color.BLUE
        )

        //敵ウィンドウの背景(地上)
        private val enemyField = FillRectData(
            DrawAreaData(
                DrawParam.ScreenW * 0.1F,
                DrawParam.ScreenH * 0.1F + ENEMY_WINDOW_HEIGHT * 0.3F,
                DrawParam.ScreenW * 0.8F,
                ENEMY_WINDOW_HEIGHT * 0.7F
            ),
            Color.GREEN
        )

        //選択ウィンドウ
        private val selectWindow = StrokeRectData(
            DrawAreaData(
                DrawParam.ScreenW * 0.05F,
                DrawParam.ScreenH * 0.6F,
                DrawParam.ScreenW * 0.9F,
                SELECT_WINDOW_HEIGHT
            ),
            Color.WHITE,
            10F
        )

        override fun update(system: GameSystem , motionEvent: GameMotionEvent): Mode {
            return this
        }

        override fun createStorage(): DrawingDataStorage {
            // ゲーム画面の四角形を含めた全ての四角形を返す
            val storage = DrawingDataStorage(Color.BLACK)
            storage.addRect(enemySky)
            storage.addRect(enemyField)
            storage.addRect(enemyWindow)
            storage.addRect(selectWindow)
            storage.addRect(enemy.getRectData(DrawParam.ScreenW / 2F, DrawParam.ScreenH * 0.1F + ENEMY_WINDOW_HEIGHT * 0.7F))

            return storage
        }
    }
}
