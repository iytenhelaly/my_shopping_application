package com.example.myshoppingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    private lateinit var Updatebutton2: Button
    private lateinit var FirstNameText: EditText
    private lateinit var LastNameText: EditText
    private lateinit var PhoneText: EditText
    private lateinit var BirthdateText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        Updatebutton2=findViewById(R.id.update)
        FirstNameText=findViewById(R.id.editTextFirstName)
        LastNameText=findViewById(R.id.editTextLastName)
        PhoneText=findViewById(R.id.editTextPhone)
        BirthdateText=findViewById(R.id.editTextBirth)

        //use email and password to save the data specific for this email
        val Email=intent.getStringExtra("email")
        val Password=intent.getStringExtra("password")
        val info=UserData(Email.toString(),Password.toString())
        info.setFirstName(FirstNameText.getText().toString())
        info.setLastName(LastNameText.getText().toString())
        info.setPhoneNumber(PhoneText.getText().toString())
        info.setBirthdate(BirthdateText.getText().toString())



        Updatebutton2.setOnClickListener {
            val intent = Intent(this, LoginInActivity::class.java)
            intent.putExtra("Account Information",info.toString())
            startActivity(intent)
        }


    }
}