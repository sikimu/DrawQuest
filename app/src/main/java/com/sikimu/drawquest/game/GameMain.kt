package com.sikimu.drawquest.game

import android.graphics.Color
import com.sikimu.drawquest.*
import com.sikimu.drawquest.drawdata.DrawAreaData
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

        /**
         * カメラ中心から指定した位置までの距離を考慮した表示位置を取得する
         *
         * @param system ゲームのシステム
         * @param center 表示するオブジェクトの中心座標
         * @return カメラ中心から指定した位置までの距離を考慮した表示位置
         */
        fun getViewCenter(system: GameSystem, center: Vector2D, cameraCenter: Vector2D): Vector2D {
            return Vector2D(system.getViewWidth() / 2F, system.getViewHeight() / 2F) + (center - cameraCenter)
        }
    }

    /** カメラ中央位置 */
    private var cameraCenter = Vector2D(0F, 0F)

    private val player = RectPlayer()
    private var playerCenter = Vector2D(200F, 200F)
    private val enemy = RectEnemy()
    private var enemyCenter = Vector2D(200F, 400F)

    // プレイヤーと敵の表示位置
    private var playerViewCenter = getViewCenter(system, playerCenter, cameraCenter)
    private var enemyViewCenter = getViewCenter(system, enemyCenter, cameraCenter)

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

            playerViewCenter = getViewCenter(system, playerCenter, cameraCenter)
            enemyViewCenter = getViewCenter(system, enemyCenter, cameraCenter)

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
                addRect(enemy.getRectData(enemyViewCenter))
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
                return Battle(system, motionEvent)
            }
            return this
        }

        override fun createStorage(): DrawingDataStorage {
            val storage = DrawingDataStorage(Color.GREEN)
            storage.addRect(player.getRectData())
            storage.addRect(enemy.getRectData(enemyViewCenter))
            storage.addRect(fillRectData)

            return storage
        }
    }

    inner class Battle(system: GameSystem, motionEvent: GameMotionEvent) : Mode() {

        // ゲーム画面の四角形を作成する
        private val enemyWindow = StrokeRectData(
            system.getViewWidth() * 0.1F, // 左端の座標
            system.getViewHeight() * 0.1F, // 上端の座標
            system.getViewWidth() * 0.8F, // 幅
            ENEMY_WINDOW_HEIGHT, // 高さ
            40F,
            Color.WHITE
        )

        private val enemySky = FillRectData(
            DrawAreaData(system.getViewWidth() * 0.1F, // 左端の座標
                system.getViewHeight() * 0.1F, // 上端の座標
                system.getViewWidth() * 0.8F, // 幅
                ENEMY_WINDOW_HEIGHT), // 高さ
            Color.BLUE
        )
        private val enemyField = FillRectData(
            DrawAreaData(system.getViewWidth() * 0.1F, // 左端の座標
            system.getViewHeight() * 0.1F + ENEMY_WINDOW_HEIGHT * 0.4F, // 上端の座標
            system.getViewWidth() * 0.8F, // 幅
            ENEMY_WINDOW_HEIGHT * 0.6F), // 高さ
            Color.GREEN
        )

        // プレイヤーの選択肢を表示する四角形を作成する
        private val selectWindow = StrokeRectData(
            system.getViewWidth() * 0.05F, // 左端の座標
            system.getViewHeight() * 0.6F, // 上端の座標
            system.getViewWidth() * 0.9F, // 幅
            SELECT_WINDOW_HEIGHT, // 高さ
            40F,
            Color.WHITE
        )

        private val enemyVector = Vector2D(system.getViewWidth() / 2F, system.getViewHeight() * 0.1F + ENEMY_WINDOW_HEIGHT * 0.7F)

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
            storage.addRect(enemy.getRectData(enemyVector))

            return storage
        }
    }
}
