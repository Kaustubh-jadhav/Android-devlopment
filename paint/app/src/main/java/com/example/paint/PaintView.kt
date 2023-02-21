package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paint.MainActivity.Companion.paintBrush
import com.example.paint.MainActivity.Companion.path

class PaintView : View {

    enum class Shape {
        LINE, CIRCLE, TRIANGLE, RECTANGLE
    }

    var params: ViewGroup.LayoutParams? = null

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
        var currentShape = Shape.LINE
    }

    private var startX = 0f
    private var startY = 0f

    private fun init() {
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    constructor(context: Context) : this(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = x
                startY = y
                path = Path() // create new path object for each shape
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                when (currentShape) {
                    Shape.LINE -> {
                        path.reset()
                        path.moveTo(startX, startY)
                        path.lineTo(x, y)
                    }
                    Shape.CIRCLE -> {
                        val radius = Math.sqrt(Math.pow((startX - x).toDouble(), 2.0) + Math.pow((startY - y).toDouble(), 2.0)).toFloat()
                        path.reset()
                        path.addCircle(startX, startY, radius, Path.Direction.CW)
                    }
                    Shape.TRIANGLE -> {
                        path.reset()
                        path.moveTo(startX, startY)
                        path.lineTo(startX + (x - startX) / 2, y)
                        path.lineTo(x, startY)
                        path.lineTo(startX, startY)
                    }
                    Shape.RECTANGLE -> {
                        path.reset()
                        path.addRect(RectF(startX, startY, x, y), Path.Direction.CW)
                    }
                }
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }


    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices) {
            paintBrush.color = colorList[i]
            canvas.drawPath(pathList[i], paintBrush)
        }
    }

}
