package com.startandoid.p0281intentextras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
    private lateinit var tvView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        tvView = findViewById(R.id.tvView)
        var intent: Intent = getIntent()
        var fName: String? = intent.getStringExtra("fname")
        var lName: String? = intent.getStringExtra("lname")
        tvView.setText("Your name is: "+fName + " " + lName)
    }
}