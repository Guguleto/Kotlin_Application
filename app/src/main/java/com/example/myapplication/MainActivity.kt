package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View.VISIBLE

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val editTxt = findViewById<EditText>(R.id.editText)
        val btn = findViewById<Button>(R.id.btn)
        val offerButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""

        btn.setOnClickListener {
            enteredName = editTxt.text.toString()

            if (enteredName == ""){
                offerButton.visibility = INVISIBLE
                textView.text = ""
                Toast.makeText(this@MainActivity,
                    "Please enter your name",Toast.LENGTH_SHORT).show()
            }else {
                val message = "Welcome $enteredName"
                textView.text = message
                editTxt.text.clear()
                offerButton.visibility = VISIBLE
            }
        }

        offerButton.setOnClickListener {
            val intent = Intent(this, SecondActivity :: class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }
}