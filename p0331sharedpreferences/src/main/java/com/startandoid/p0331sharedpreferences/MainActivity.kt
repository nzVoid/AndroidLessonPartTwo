package com.startandoid.p0331sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etText:EditText
    private lateinit var btnSave:Button
    private lateinit var btnLoad:Button
    private lateinit var sPref:SharedPreferences
    val SAVED_TEXT:String = "saved_text"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etText = findViewById(R.id.etText)
        (findViewById<Button>(R.id.btnSave)).setOnClickListener(this::onClick)
        (findViewById<Button>(R.id.btnLoad)).setOnClickListener(this::onClick)
        loadText()
    }

    fun onClick(v: View){
        when(v.id){
            R.id.btnSave -> saveText()
            R.id.btnLoad -> loadText()
        }
    }

    fun saveText(){
        sPref = getPreferences(Context.MODE_PRIVATE)
        var ed:SharedPreferences.Editor = sPref.edit()
        ed.putString(SAVED_TEXT, etText.getText().toString())
        ed.commit()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    fun loadText(){
        sPref = getPreferences(Context.MODE_PRIVATE)
        var savedText: String? = sPref.getString(SAVED_TEXT, "")
        etText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }
}