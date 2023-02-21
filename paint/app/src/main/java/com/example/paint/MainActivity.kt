package com.example.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.paint.PaintView.Companion.colorList
import com.example.paint.PaintView.Companion.currentBrush
import com.example.paint.PaintView.Companion.currentShape
import com.example.paint.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
        var currentShape = "Freehand"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)
        val rectangleBtn = findViewById<Button>(R.id.squareShape)
        val circleBtn = findViewById<Button>(R.id.circleShape)
        val triangleBtn = findViewById<Button>(R.id.triangleShape)
        val lineBtn = findViewById<Button>(R.id.lineShape)

        paintBrush.isAntiAlias = true
        paintBrush.color = Color.BLACK
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 10f

        redBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }

        blueBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        blackBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }

        eraser.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        rectangleBtn.setOnClickListener {
            Toast.makeText(this,"Rectangle",Toast.LENGTH_SHORT).show()
            currentShape = PaintView.Shape.RECTANGLE.toString()
        }

        circleBtn.setOnClickListener {
            Toast.makeText(this,"circle",Toast.LENGTH_SHORT).show()
            currentShape = PaintView.Shape.CIRCLE.toString()
        }

        triangleBtn.setOnClickListener {
            Toast.makeText(this,"triangle",Toast.LENGTH_SHORT).show()
            currentShape = PaintView.Shape.TRIANGLE.toString()
        }
        lineBtn.setOnClickListener{
            Toast.makeText(this,"line",Toast.LENGTH_SHORT).show()
            currentShape = PaintView.Shape.LINE.toString()
        }
    }

    private fun currentColor(color:Int){
        currentBrush = color
        path = Path()
    }
}
