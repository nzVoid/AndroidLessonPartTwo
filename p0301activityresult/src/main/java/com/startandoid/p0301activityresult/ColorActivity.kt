package com.startandoid.p0301activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ColorActivity : AppCompatActivity() {
    private lateinit var btnRed:Button
    private lateinit var btnGreen:Button
    private lateinit var btnBlue:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        btnRed = findViewById(R.id.btnRed)
        btnRed.setOnClickListener(this::onClick)

        btnGreen = findViewById(R.id.btnGreen)
        btnGreen.setOnClickListener(this::onClick)

        btnBlue = findViewById(R.id.btnBlue)
        btnBlue.setOnClickListener(this::onClick)
    }

    fun onClick(v:View){
        var intent: Intent = Intent()
        when(v.id){
            R.id.btnRed -> intent.putExtra("color", Color.RED)
            R.id.btnGreen -> intent.putExtra("color", Color.GREEN)
            R.id.btnBlue -> intent.putExtra("color", Color.BLUE)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}