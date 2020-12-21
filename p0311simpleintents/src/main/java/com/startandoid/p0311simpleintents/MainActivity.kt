package com.startandoid.p0311simpleintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnWeb: Button
    private lateinit var btnMap: Button
    private lateinit var btnCall: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWeb = findViewById(R.id.btnWeb)
        btnMap = findViewById(R.id.btnMap)
        btnCall = findViewById(R.id.btnCall)
        btnWeb.setOnClickListener(this::onClick)
        btnMap.setOnClickListener(this::onClick)
        btnCall.setOnClickListener(this::onClick)
    }

    fun onClick(v: View){
        var intent:Intent
        when(v.id){
            R.id.btnWeb ->{
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"))
                startActivity(intent)
            }
            R.id.btnMap ->{
                intent = Intent()
                intent.setAction(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("geo:55.754283,37.62002"))
                startActivity(intent)
            }
            R.id.btnCall ->{
                intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:12345"))
                startActivity(intent)
            }
        }
    }
}