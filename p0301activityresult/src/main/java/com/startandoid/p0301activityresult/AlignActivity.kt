package com.startandoid.p0301activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button

class AlignActivity : AppCompatActivity() {
    private  lateinit var btnLeft:Button
    private  lateinit var btnCenter:Button
    private  lateinit var btnRight:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)
        btnLeft = findViewById(R.id.btnLeft)
        btnCenter = findViewById(R.id.btnCenter)
        btnRight = findViewById(R.id.btnRight)
        btnLeft.setOnClickListener(this::onClick)
        btnCenter.setOnClickListener(this::onClick)
        btnRight.setOnClickListener(this::onClick)
    }

    fun onClick(v: View){
        var intent: Intent = Intent()
        when(v.id){
            R.id.btnLeft -> intent.putExtra("alignment", Gravity.LEFT)
            R.id.btnCenter -> intent.putExtra("alignment", Gravity.CENTER)
            R.id.btnRight -> intent.putExtra("alignment", Gravity.RIGHT)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}