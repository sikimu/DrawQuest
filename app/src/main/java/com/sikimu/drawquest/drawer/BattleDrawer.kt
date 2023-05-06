package com.sikimu.drawquest.drawer

import android.graphics.Color
import com.sikimu.drawquest.drawdata.*

/**
 * 戦闘画面の描画
 */
class BattleDrawer {
    companion object{
        // 敵を表示する矩形の描画データ
        private val enemyWindow = StrokeRectData(
            DrawPoint(-400F, -700F),
            DrawSize(800F, 600F),
            Color.WHITE,
            10F
        )

        // 敵ウィンドウの背景(空)
        private val enemySky = FillRectData(
            DrawPoint(-400F, -700F),
            DrawSize(800F, 200F),
            Color.BLUE
        )

        //敵ウィンドウの背景(地上)
        private val enemyField = FillRectData(
            DrawPoint(-400F, -500F),
            DrawSize(800F, 400F),
            Color.GREEN
        )

        private val selectWindow = StrokeRectData(
            DrawPoint(-500F, 400F),
            DrawSize(1000F, 400F),
            Color.WHITE,
            10F
        )

        /**
         * プレイヤーウィンドウ
         */
        private val playerWindow = StrokeRectData(
            DrawPoint(-400F, -50F),
            DrawSize(800F, 400F),
            Color.WHITE,
            10F
        )

        /**
         * プレイヤーウィンドウの背景
         */
        private val playerBg = FillRectData(
            DrawPoint(-400F, -50F),
            DrawSize(800F, 400F),
            Color.LTGRAY
        )

        /**
         * 敵のウィンドウをまとめて描画する描画データ配列の作成
         */
        fun createEnemyWindow(): List<DrawData> {
            val enemy = RectEnemyDrawer.create(DrawPoint(0F, -300F))
            return listOf(enemySky , enemyField, enemyWindow, enemy)
        }

        /**
         * プレイヤーのを描画する描画データの作成
         */
        fun createPlayerWindow(color : Int) : List<DrawData> {
            val player = RectPlayerDrawer.create(DrawPoint(0F, 150F), color)
            return listOf(playerBg, playerWindow, player)
        }

        /**
         * 選択ウィンドウを描画する描画データの作成
         */
        fun createSelectWindow(): DrawData {
            return selectWindow
        }
    }
}