package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createGreet.setOnClickListener()

    }
    private lateinit var nameInput : EditText
    fun createBirthdayCard(view: View) {
        nameInput = findViewById(R.id.nameInput)
        val name = nameInput.editableText.toString()
        Toast.makeText(this,"Button was clicked",Toast.LENGTH_LONG).show()
        val intent = Intent(this,birthdaygreeting::class.java)
        intent.putExtra(birthdaygreeting.NAME_EXTRA,name)
        startActivity(intent)
    }


//    override fun onPause() {
//        super.onPause()
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
}
