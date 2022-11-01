package com.example.myshoppingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var SignUpbutton: Button
    private lateinit var SignInbutton: Button
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var EmailText: EditText
    private lateinit var PassText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAuth = FirebaseAuth.getInstance()
        SignUpbutton = findViewById(R.id.SignUp)
        SignInbutton = findViewById(R.id.SignIn)
        EmailText = findViewById(R.id.editTextEmail)
        PassText = findViewById(R.id.editTextPassword)



        SignInbutton.setOnClickListener {
            val email = this.EmailText.getText().toString()
            val password = this.PassText.getText().toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, LoginInActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"This account is not registered. Please sign up to create an account", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_LONG).show()
            }
        }

        SignUpbutton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }

}
