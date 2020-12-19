package com.startandoid.p0281intentextras

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etFName: EditText
    private lateinit var etLName: EditText
    private lateinit var btnSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener(this::onClick)
    }

    fun onClick(v: View){
        var intent: Intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("fname", etFName.getText().toString())
        intent.putExtra("lname", etLName.getText().toString())
        startActivity(intent)
    }
}