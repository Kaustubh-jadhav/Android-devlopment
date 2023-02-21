package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class birthdaygreeting : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA = "name_extra"
    }
    private lateinit var BirthdayGreeting :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        BirthdayGreeting = findViewById(R.id.BirthdayGreeting)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthdaygreeting)
        val name = intent.getStringExtra(NAME_EXTRA)
        BirthdayGreeting.text = "HAPPY BIRTHDAY $name"
    }
}