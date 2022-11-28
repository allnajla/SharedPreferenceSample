package com.example.sharedpreferencesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var btnSave: Button
    lateinit var btnRetrive: Button
    lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference:SharedPreference=SharedPreference(this)

        edtName=findViewById(R.id.edt_name)
        edtEmail=findViewById(R.id.edt_email)
        btnClear=findViewById(R.id.btn_clear)
        btnSave=findViewById(R.id.btn_save)
        btnRetrive=findViewById(R.id.btn_retriev)

        btnSave.setOnClickListener {

            val name=edtName.editableText.toString()
            val email=edtEmail.editableText.toString()
            sharedPreference.save("name",name)
            sharedPreference.save("email",email)
            Toast.makeText(this@MainActivity,"Data saved to shared preferences", Toast.LENGTH_SHORT).show()

        }
        btnRetrive.setOnClickListener {
            if (sharedPreference.getValueString("name")!=null) {
                edtName.hint = sharedPreference.getValueString("name")!!
                Toast.makeText(this@MainActivity,"Data Retrieved from shared preferences",Toast.LENGTH_SHORT).show()
            }else{
                edtName.hint="NO value found"
            }
            if (sharedPreference.getValueString("email")!=null) {
                edtEmail.hint = sharedPreference.getValueString("email")!!
            }else{
                edtEmail.hint="No value found"
            }


        }

        btnClear.setOnClickListener {
            sharedPreference.clearSharedPreference()
            Toast.makeText(this@MainActivity,"Data Cleared from shared preferences",Toast.LENGTH_SHORT).show()
        }
    }
}