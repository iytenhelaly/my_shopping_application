package com.example.myshoppingapplication

import android.widget.Button

class UserData {
    private lateinit var Email: String
    private lateinit var Password: String
    private lateinit var FirstName: String
    private lateinit var LastName: String
    private lateinit var PhoneNumber: String
    private lateinit var Birthdate: String

    constructor(Email:String,Password:String){
        this.Email=Email
        this.Password=Password
    }

    fun setFirstName(FirstName:String) {
        this.FirstName=FirstName

    }

    fun setLastName(LastName:String) {
        this.LastName=LastName

    }

    fun setPhoneNumber(PhoneNumber:String) {
        this.PhoneNumber=PhoneNumber

    }

    fun setBirthdate(Birthdate:String) {
        this.Birthdate=Birthdate

    }

    override fun toString() : String{
       val info=this.FirstName + " " + this.LastName + " " + this.PhoneNumber + " " + this.Birthdate + " "
        return info
    }
}
