package com.example.myshoppingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var RegisterButton: Button
    private lateinit var emailText: EditText
    private lateinit var passText: EditText
    private lateinit var confirmPassText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        firebaseAuth = FirebaseAuth.getInstance()
        RegisterButton=findViewById(R.id.Register)
        emailText=findViewById(R.id.editTextNewEmail)
        passText=findViewById(R.id.editTextNewPassword)
        confirmPassText=findViewById(R.id.editTextConfirmPass)

        RegisterButton.setOnClickListener {
            val email1 = this.emailText.getText().toString().trim()
            val pass1 = this.passText.getText().toString().trim()
            val confirmPass = this.confirmPassText.getText().toString().trim()

            if(email1.isNotEmpty() && pass1.isNotEmpty() && confirmPass.isNotEmpty()){
                if(pass1 == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this, "Please Try Again", Toast.LENGTH_LONG).show()
                        }
                    }

                }
                else{
                    Toast.makeText(this, "Passwords should be matching", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_LONG).show()
            }
        }

    }
}