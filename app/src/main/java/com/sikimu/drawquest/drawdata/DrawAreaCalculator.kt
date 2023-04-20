package com.sikimu.drawquest.drawdata

import com.sikimu.drawquest.Area

class DrawAreaCalculator{
    companion object{

        /**
         * 座標出力
         */
        fun calcArea(drawPoint : DrawPoint, drawSize : DrawSize, screenWidth : Int , screenHeight : Int): Area {
            val x = drawPoint.x.calc(screenWidth, screenHeight)
            val y = drawPoint.y.calc(screenWidth, screenHeight)
            val w = drawSize.width.calc(screenWidth, screenHeight)
            val h = drawSize.height.calc(screenWidth, screenHeight)
            return Area(x, y, w, h)
        }

        /**
         * 中央に合わせて座標出力
         */
        fun calcAreaCenter(drawPoint : DrawPoint, drawSize : DrawSize, screenWidth : Int , screenHeight : Int): Area {
            val x = drawPoint.x.calc(screenWidth, screenHeight)
            val y = drawPoint.y.calc(screenWidth, screenHeight)
            val w = drawSize.width.calc(screenWidth, screenHeight)
            val h = drawSize.height.calc(screenWidth, screenHeight)
            return Area(x - (w / 2), y - (h / 2), w, h)
        }
    }
}
