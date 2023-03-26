import android.graphics.Color
import com.sikimu.drawquest.GameMotionEvent
import com.sikimu.drawquest.GameSystem
import com.sikimu.drawquest.drawdata.FillRectData
import com.sikimu.drawquest.Vector2D
import com.sikimu.drawquest.game.GameMain
import com.sikimu.drawquest.game.GameTitle
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class GameTitleTest {

    @Test
    fun testUpdate_returnsGameMain_whenMotionEventActionUp() {
        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()
        val gameSystem = Mockito.mock(GameSystem::class.java)

        // MotionEvent.ACTION_UPの場合はGameMainのインスタンスが返る

        val result = gameTitle.update(gameSystem, GameMotionEvent(Vector2D(150f, 550f) , GameMotionEvent.Action.UP))
        assertTrue(result is GameMain)
    }

    @Test
    fun testUpdate_returnsGameTitle_whenMotionEventNotNull() {
        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()
        val gameSystem = Mockito.mock(GameSystem::class.java)

        // MotionEvent.ACTION_UP以外の場合はGameTitleのインスタンスが返る
        val result = gameTitle.update(gameSystem, GameMotionEvent(Vector2D(150f, 550f), GameMotionEvent.Action.DOWN))
        assertTrue(result is GameTitle)
    }

    @Test
    fun testCreateStorage_returnsDrawingDataStorage() {
        // テスト対象のインスタンスを生成
        val gameTitle = GameTitle()

        // createStorage()で返される背景の色が黄色であることを確認
        val result = gameTitle.createStorage()
        assertEquals(result.getBackgroundColor(), Color.YELLOW)

        // ボタンの矩形があることを確認
        val rect = FillRectData(100F,500F,500F,100F, Color.WHITE)
        assertEquals(result.getStorage()[0] , rect)
    }
}
