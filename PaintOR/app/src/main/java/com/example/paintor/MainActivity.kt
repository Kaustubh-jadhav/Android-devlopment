package com.example.paintor

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.paintor.paintView.Companion.colorList
import com.example.paintor.paintView.Companion.currentBrush
import com.example.paintor.paintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val whiteBtn = findViewById<ImageButton>(R.id.whiteColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)

        val s1Btn = findViewById<Button>(R.id.sa)
        val s2Btn = findViewById<Button>(R.id.sb)
        val s3Btn = findViewById<Button>(R.id.sc)
        val s4Btn = findViewById<Button>(R.id.sd)


        redBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.RED
            currentColor(paintBrush.color)
        }

        blueBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.BLUE
            currentColor(paintBrush.color)
        }

        blackBtn.setOnClickListener {
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.BLACK
            currentColor(paintBrush.color)
        }
        whiteBtn.setOnClickListener {
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        s1Btn.setOnClickListener {
            size(10f)
        }
        s2Btn.setOnClickListener {
            size(20f)
        }
        s3Btn.setOnClickListener {
            size(30f)
        }
        s4Btn.setOnClickListener {
            size(40f)
        }
    }
    private fun currentColor(color : Int){
        currentBrush = color
        path = Path()
    }
    private fun size(s : Float){
        paintBrush.strokeWidth = s
        path = Path()
    }

}