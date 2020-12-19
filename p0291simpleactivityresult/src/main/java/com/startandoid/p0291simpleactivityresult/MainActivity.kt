package com.startandoid.p0291simpleactivityresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvName:TextView
    private lateinit var btnName:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById(R.id.tvName)
        btnName = findViewById(R.id.btnName)
        btnName.setOnClickListener(this::onClick)
    }

    fun onClick(v: View){
        var intent: Intent = Intent(this, NameActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }
        val name = data.getStringExtra("name")
        tvName.text = "Your name is $name"
    }
}