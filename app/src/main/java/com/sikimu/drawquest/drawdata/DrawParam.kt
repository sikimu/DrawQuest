package com.sikimu.drawquest.drawdata

/**
 * 描画用パラメータ
 * Pixel、ScreenW、ScreenHをサポートしています。
 * 四則演算も可能です。
 *
 * @see DrawParam.Pixel
 * @see DrawParam.ScreenW
 * @see DrawParam.ScreenH
 */
sealed class DrawParam {

    /**
     * ピクセル
     */
    data class Pixel(val value: Float) : DrawParam()

    /**
     * 画面横幅
     */
    object ScreenW : DrawParam()
    /**
     * 画面縦幅
     */
    object ScreenH : DrawParam()

    /**
     * 式(四則演算経由で生成される)
     */
    private data class Expression(val value1: DrawParam, val operator: DrawOperator, val value2 : DrawParam) : DrawParam()

    /**
     * 描画用のパラメータを計算します。
     * @param screenW 画面横幅
     * @param screenH 画面縦幅
     * @return 描画用のパラメータ
     */
    fun calc(screenW: Int, screenH: Int): Float {
        return when (this) {
            is Pixel -> value
            ScreenW -> screenW.toFloat()
            ScreenH -> screenH.toFloat()
            is Expression -> operator.calc(value1.calc(screenW, screenH), value2.calc(screenW, screenH))
        }
    }

    /**
     * 演算子
     */
    private sealed class DrawOperator  {
        abstract fun calc(value1 : Float , value2 : Float) : Float

        object Plus : DrawOperator(){

            override fun calc(value1 : Float , value2 : Float) : Float {
                return value1 + value2
            }
        }

        object Minus : DrawOperator(){

            override fun calc(value1 : Float , value2 : Float) : Float {
                return value1 - value2
            }
        }

        object Multiply : DrawOperator(){

            override fun calc(value1 : Float , value2 : Float) : Float {
                return value1 * value2
            }
        }

        object Divide : DrawOperator(){

            override fun calc(value1 : Float , value2 : Float) : Float {
                return value1 / value2
            }
        }
    }

    /**
     * 足し算の登録
     */
    operator fun plus(param: DrawParam): DrawParam {
        return Expression(this, DrawOperator.Plus, param)
    }
    /**
     * 足し算の登録
     */
    operator fun plus(value: Float): DrawParam {
        return Expression(this, DrawOperator.Plus, Pixel(value))
    }

    /**
     * 引き算の登録
     */
    operator fun minus(param: DrawParam): DrawParam {
        return Expression(this, DrawOperator.Minus, param)
    }
    /**
     * 引き算の登録
     */
    operator fun minus(value: Float): DrawParam {
        return Expression(this, DrawOperator.Minus, Pixel(value))
    }

    /**
     * 掛け算の登録
     */
    operator fun times(param: DrawParam): DrawParam {
        return Expression(this, DrawOperator.Multiply, param)
    }
    /**
     * 掛け算の登録
     */
    operator fun times(value: Float): DrawParam {
        return Expression(this, DrawOperator.Multiply, Pixel(value))
    }

    /**
     * 割り算の登録
     */
    operator fun div(param: DrawParam): DrawParam {
        return Expression(this, DrawOperator.Divide, param)
    }

    /**
     * 割り算の登録
     */
    operator fun div(value: Float): DrawParam {
        return Expression(this, DrawOperator.Divide, Pixel(value))
    }
}