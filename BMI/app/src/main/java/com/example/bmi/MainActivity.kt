package com.example.bmi

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btnCalculate.setOnClickListener {

            if(!edtWeight.text.toString().equals("") && !edtHeightFt.text.toString().equals("")
                && !edtHeightIn.text.toString().equals(""))
            {
                val wt = (edtWeight.text.toString()).toDouble()
                val htFeet = (edtHeightFt.text.toString()).toDouble()
                val htInch = (edtHeightIn.text.toString()).toDouble()

                val totalInch = htFeet*12 + htInch;
                val totalCm = totalInch * 2.54

                val totalM = totalCm / 100

                val Bmi = wt/(totalM * totalM)

                txtTitle.text = "Your BMI "
                txtResult.text = "${Bmi.toInt()}"

                if(Bmi>25) {
                    Toast.makeText(this@MainActivity, "You are Overweight", Toast.LENGTH_SHORT)
                        .show()
                    txtMsg.text = "You are Overweight"
                } else if(Bmi<18){
                    Toast.makeText(this@MainActivity, "You are UnderWeight", Toast.LENGTH_SHORT)
                        .show()
                    txtMsg.text = "You are UnderWeight"
                }else{
                    Toast.makeText(this@MainActivity, "You are Healthy", Toast.LENGTH_SHORT)
                        .show()
                    txtMsg.text = "You are Healthy"

                }

            }
            else{
                Toast.makeText(this@MainActivity, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
        }


    }
}