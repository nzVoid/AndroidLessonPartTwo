package com.startandoid.p0341simplesqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val LOG_TAG:String = "myLogs"
    private lateinit var btnAdd:Button
    private lateinit var btnRead:Button
    private lateinit var btnClear:Button
    private lateinit var etName:EditText
    private lateinit var etEmail:EditText
    private lateinit var dbHelper:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById<Button>(R.id.btnAdd)).setOnClickListener(this::onClick)
        (findViewById<Button>(R.id.btnRead)).setOnClickListener(this::onClick)
        (findViewById<Button>(R.id.btnClear)).setOnClickListener(this::onClick)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)

        dbHelper = DBHelper(this)
    }

    fun onClick(v:View){
        var cv: ContentValues = ContentValues()

        var name:String = etName.getText().toString()
        var email:String = etEmail.getText().toString()

        var db:SQLiteDatabase = dbHelper.getWritableDatabase()

        when(v.id){
            R.id.btnAdd ->{
                Log.d(LOG_TAG, "Insert in mytable: ")
                cv.put("name", name)
                cv.put("email", email)
                var rowID:Long = db.insert("mytable", null, cv)
                Log.d(LOG_TAG, "row inserted, ID = $rowID")
            }
            R.id.btnRead ->{
                Log.d(LOG_TAG, "Rows in mytable: ")
                var c:Cursor = db.query("mytable", null, null, null, null,null,null)
                if(c.moveToFirst()) {
                    var idColIndex: Int = c.getColumnIndex("id")
                    var nameColIndex: Int = c.getColumnIndex("name")
                    var emailColIndex: Int = c.getColumnIndex("email")

                    do {
                        Log.d(LOG_TAG, "ID = " + c.getInt(idColIndex) + ", name = " + c.getString(nameColIndex) + ", email = " + c.getString(emailColIndex))
                    }
                    while (c.moveToNext())
                }
                else{
                    Log.d(LOG_TAG, "0 rows")
                }
                c.close()
            }
            R.id.btnClear ->{
                Log.d(LOG_TAG,"Clear mytable:")
                var clearCount:Int = db.delete("mytable", null, null)
                Log.d(LOG_TAG, "deleted rows count = " + clearCount)
            }
        }
        dbHelper.close()
    }

    internal class DBHelper(context: Context?):SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d("myLogs", "--- onCreate database ---")
            // создаем таблицу с полями
            db.execSQL("create table mytable (" + "id integer primary key autoincrement," + "name text," + "email text" + ");")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int){

        }
    }
}