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
            DrawAreaData(
                -400F,
                -700F,
                800F,
                600F
            ) ,
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
            DrawAreaData(
                -500F,
                400F,
                1000F,
                400F
            ) ,
            Color.WHITE,
            10F
        )

        /**
         * プレイヤーウィンドウ
         */
        private val playerWindow = StrokeRectData(
            DrawAreaData(
                -400F,
                -50F,
                800F,
                400F
            ) ,
            Color.WHITE,
            10F
        )

        /**
         * 敵のウィンドウをまとめて描画する描画データ配列の作成
         */
        fun createEnemyWindow(): List<DrawData> {
            return listOf(enemySky , enemyField, enemyWindow)
        }

        /**
         * プレイヤーのを描画する描画データの作成
         */
        fun createPlayerWindow(): DrawData {
            return playerWindow
        }

        /**
         * 選択ウィンドウを描画する描画データの作成
         */
        fun createSelectWindow(): DrawData {
            return selectWindow
        }
    }
}