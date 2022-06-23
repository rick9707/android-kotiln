package com.example.binary

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyCustomView(this))
    }
}

class MyCustomView(context: Context) : View(context){
    var tree_array = arrayOf(9,8,7,6,5,4,3,2,1,0)
    var arr = tree_array
    var i = 1
    var line = 2
    var a = 0
    var x = 500
    var y = 0
    var text ="a"
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.strokeWidth = 3f
        paint.style = Paint.Style.FILL

        val paint1 = Paint()
        paint1.isAntiAlias = true
        paint1.color = Color.YELLOW
        paint1.strokeWidth = 4f
        paint1.textSize = 50f
        paint1.style = Paint.Style.STROKE

        val paint2 = Paint()
        paint2.isAntiAlias = true
        paint2.color = Color.BLACK
        paint2.strokeWidth = 4f
        paint2.textSize = 50f
        paint2.style = Paint.Style.STROKE
        while(i<arr.size) {
            if (i < line) {
                text = tree_array[i].toString()
                if(a % 2 == 1){
                    canvas.drawLine(x + 2 * x * a.toFloat(), 200f + y.toFloat(),
                        2 * x * a.toFloat(), y.toFloat()+20f,paint2)
                }
                else{
                    if(i == 1){
                        print(a)
                    }
                    else{
                    canvas.drawLine(x + 2 * x * a.toFloat(), 200f + y.toFloat(),
                        x*2 + 2 * x * a.toFloat(), y.toFloat()+20f,paint2)
                }}
                canvas.drawCircle(x + 2 * x * a.toFloat(), 200f + y.toFloat(), 50f, paint)
                canvas.drawText(text, x + 2 * x * a.toFloat() - 15f, 200f + y.toFloat() +15f, paint1)
                i++
                a++
            } else {
                y = y + 200
                x = x / 2
                line = line * 2
                a = 0

            }
        }
    }
}