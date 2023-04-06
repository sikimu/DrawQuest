import android.graphics.Color
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.Vector2D
import com.sikimu.drawquest.WorldData
import com.sikimu.drawquest.drawdata.DrawAreaData
import com.sikimu.drawquest.drawdata.FillRectData
import com.sikimu.drawquest.game.GameMain
import com.sikimu.drawquest.game.GameTitle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameTitleTest {

    @Test
    fun testUpdate_returnsGameMain_whenMotionEventActionUp() {
        // テスト対象のインスタンスを生成
        val worldData = WorldData()
        val gameTitle = GameTitle()

        // MotionEvent.ACTION_UPの場合はGameMainのインスタンスが返る

        val result = gameTitle.update(worldData, GameMotionEvent(Vector2D(150f, 550f) , GameMotionEvent.Action.UP))
        assertTrue(result is GameMain)
    }

    @Test
    fun testUpdate_returnsGameTitle_whenMotionEventNotNull() {

        val worldData = WorldData()

        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()

        // MotionEvent.ACTION_UP以外の場合はGameTitleのインスタンスが返る
        val result = gameTitle.update(worldData, GameMotionEvent(Vector2D(150f, 550f), GameMotionEvent.Action.DOWN))
        assertTrue(result is GameTitle)
    }

    @Test
    fun testCreateStorage_returnsDrawingDataStorage() {

        val worldData = WorldData()

        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()

        // createStorage()で返される背景の色が黄色であることを確認
        val result = gameTitle.createStorage(worldData)
        assertEquals(result.getBackgroundColor(), Color.YELLOW)

        // ボタンの矩形があることを確認
        val rect = FillRectData(DrawAreaData(100F,500F,500F,100F) , Color.WHITE)
        assertEquals(result.getStorage()[0] , rect)
    }
}
