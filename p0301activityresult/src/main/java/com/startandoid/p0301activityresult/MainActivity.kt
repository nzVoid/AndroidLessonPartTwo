package com.startandoid.p0301activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tvText:TextView
    private lateinit var btnColor:Button
    private lateinit var btnAlign:Button
    val REQUEST_CODE_COLOR:Int = 1
    val REQUEST_CODE_ALIGN:Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)
        btnColor = findViewById(R.id.btnColor)
        btnColor.setOnClickListener(this::onClick)
        btnAlign = findViewById(R.id.btnAlign)
        btnAlign.setOnClickListener(this::onClick)
    }

    fun onClick(v:View){
        var intent: Intent
        when(v.id){
            R.id.btnColor ->{
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }
            R.id.btnAlign ->{
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("myLogs", "requestCode = $requestCode, resultCode = $resultCode")
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                REQUEST_CODE_COLOR ->{
                    var color:Int = data!!.getIntExtra("color", Color.RED)
                    tvText.setTextColor(color)
                }
                REQUEST_CODE_ALIGN ->{
                    var align:Int = data!!.getIntExtra("alignment", Gravity.LEFT)
                    tvText.setGravity(align)
                }
            }
        }
        else{
            Toast.makeText(this,"Wrong result", Toast.LENGTH_SHORT).show()
        }
    }

}