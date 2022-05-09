import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyCustomView(this))
    }
}
class MyCustomView(Context: Context) : View(Context){
    override fun onDraw(canvas : Canvas){
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.GRAY
        canvas.drawLine(20f,20f,600f,20f,paint)

        paint.strokeWidth = 10f
        paint.color = Color.RED
        canvas.drawLine(20f,60f,600f,60f,paint)

        paint.strokeWidth = 30f
        canvas.drawPoint(20f,90f,paint)

        paint.strokeWidth = 5f
        paint.style = Paint.Style.FILL
        val rect1 = Rect(30,130,30+100,130+100)
        canvas.drawRect(rect1,paint)

        paint.style = Paint.Style.STROKE
        val rect2 = Rect(140,130,140+100,130+100)
        canvas.drawRect(rect2,paint)

        paint.style = Paint.Style.FILL_AND_STROKE
        val rect3 = Rect(300,130,300+100,130+100)
        canvas.drawRect(rect3,paint)

        paint.style = Paint.Style.STROKE
        val rect4 = RectF(420f,130f,420f+100f,130f+100f)
        canvas.drawRoundRect(rect4,10f,10f,paint)

        val rect5 = RectF(550f,130f,550f+100f,130f+100f)
        canvas.drawRoundRect(rect5,50f,50f,paint)

        canvas.drawCircle(680f,130f,50f,paint)
        canvas.drawPoint(680f,130f,paint)
    }
}
