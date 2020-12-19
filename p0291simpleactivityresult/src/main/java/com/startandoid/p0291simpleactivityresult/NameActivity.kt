package com.startandoid.p0291simpleactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class NameActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var btnOk:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        etName = findViewById(R.id.etName)
        btnOk = findViewById(R.id.btnOK)
        btnOk.setOnClickListener(this::onClick)
    }

    fun onClick(v:View){
        var intent:Intent = Intent()
        intent.putExtra("name", etName.getText().toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}