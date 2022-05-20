package com.example.week9_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object{
        const val LINE = 1
        const val CIRCLE = 2
        const val SQUARE = 3
        var curShape = LINE
        internal var myShapes: MutableList<MyShape> = ArrayList()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SimplePainter(this))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0,1,0, "Draw Line")
        menu?.add(0,2,0,"Draw Circle")
        menu?.add(0,3,0, "Draw Square")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> {
                curShape = LINE
                return true
            }
            2 -> {
                curShape = CIRCLE
                return true
            }
            3 -> {
                curShape = SQUARE
            }
        }
        return super.onOptionsItemSelected(item)
    }

    class SimplePainter(context: Context) : View(context) {
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f
        val paint = Paint()


        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    stopX = event.x
                    stopY = event.y
                    this.invalidate()
                }

                MotionEvent.ACTION_UP -> {
                    val shape = MyShape()
                    shape.shapeType = curShape
                    shape.startX = startX.toInt()
                    shape.startY = startY.toInt()
                    shape.stopX = stopX.toInt()
                    shape.stopY = stopY.toInt()
                    myShapes.add(shape)

                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED
            for (i in myShapes.indices) {

                val shape2 = myShapes[i]

                when(shape2.shapeType) {
                    LINE -> {
                        canvas.drawLine(shape2.startX.toFloat(),
                            shape2.startY.toFloat(), shape2.stopX.toFloat(),
                            shape2.stopY.toFloat(),
                            paint)
                    }
                    CIRCLE -> {
                        val radius = Math.sqrt(
                            Math.pow((shape2.stopX - shape2.startX).toDouble(), 2.0) +
                                    Math.pow((shape2.stopY - shape2.startY).toDouble(), 2.0)
                        )
                        canvas.drawCircle(shape2.startX.toFloat(), shape2.startY.toFloat(), radius.toFloat(), paint)
                    }
                    SQUARE -> {
                        canvas.drawRect(shape2.startX.toFloat(), shape2.startY.toFloat(), shape2.stopX.toFloat(), shape2.stopY.toFloat(), paint)
                    }
                }
            }


            when(curShape) {
                LINE -> {
                    canvas?.drawLine(startX, startY, stopX, stopY, paint)
                }
                CIRCLE -> {
                    val radius = Math.sqrt(
                        Math.pow((stopX - startX).toDouble(), 2.0) +
                                Math.pow((stopY - startY).toDouble(), 2.0)
                    )
                    canvas?.drawCircle(startX, startY, radius.toFloat(), paint)
                }
                SQUARE -> {
                    canvas?.drawRect(startX, startY, stopX, stopY, paint)
        }
    }}}

}

class MyShape {


    var shapeType = 0
    var startX = 0
    var startY: Int = 0
    var stopX: Int = 0
    var stopY: Int = 0
}
