 package com.example.myshoppingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

 class LoginInActivity : AppCompatActivity() {
    private lateinit var Updatebutton: Button
    private lateinit var Locationbutton: Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_in)
        Updatebutton=findViewById(R.id.UpdateData)
        Locationbutton=findViewById(R.id.MarkYourLocation)
        Updatebutton.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        Locationbutton.setOnClickListener {
            val intent = Intent(this, MapsActivity2::class.java)
            startActivity(intent)
        }
        


    }
}