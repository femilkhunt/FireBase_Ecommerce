package com.example.first_project

import   android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.first_project.databinding.CreateAccActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class createAccActivity : AppCompatActivity() {

    val emailFormat : String = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    var emailStatus : Boolean = false
    private lateinit var auth : FirebaseAuth
    lateinit var database : DatabaseReference
    var binding : CreateAccActivityBinding? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateAccActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = Firebase.auth
        database = Firebase.database.reference

        binding!!.createAccDoneBtn.setOnClickListener(){

            //proper Input Validation's Condition
            if(binding!!.createAccEmailBtn.text?.toString()?.length!! >0 && binding!!.createAccPassBtn.text?.length!! >0 && binding!!.createAccPhoneNoBtn.text.toString().length >0){
                emailStatus = checkEmailValidation(binding!!.createAccEmailBtn.text.toString())

                //proper Email, Password and PhoneNo Format's Condition
                if(emailStatus == true && binding!!.createAccPassBtn.text?.length!! >=6 && binding!!.createAccPhoneNoBtn.text?.toString()?.length ==10){

                    //Uploading Data in FireBase
                        auth.createUserWithEmailAndPassword(binding!!.createAccEmailBtn.text.toString(),binding!!.createAccPassBtn.text.toString()).addOnCompleteListener(this){
                            if(it.isSuccessful) {

                                //getting uid for uniqunes for different account
                                var userID = it.result.user?.uid

                                //binding data to in a varaiable to set it in dataBase
                                var userInfo = dataClass(binding!!.createAccEmailBtn.text.toString(),binding!!.createAccPassBtn.text.toString())

                                if (userID != null) {
                                    database.child("users").child(userID).setValue(userInfo).addOnCompleteListener {
                                        if (it.isSuccessful){
                                            Toast.makeText(this,"Data Successfully Stored in DataBase",Toast.LENGTH_SHORT).show()
                                            startActivity(Intent(this, MainActivity::class.java))
                                        }
                                    }.addOnFailureListener {
                                            Toast.makeText(this,"Some Error Occured in Saving Data in DataBase",Toast.LENGTH_SHORT).show()
                                    }
                                }

                            }
                        }.addOnFailureListener{
                                    Toast.makeText(this,"Some Error Occur",Toast.LENGTH_SHORT).show()
                        }
                }else{

                    if(emailStatus == false){
                        Toast.makeText(this,"Enter Proper Email",Toast.LENGTH_SHORT).show()
                    }
                    if(binding!!.createAccPassBtn.text?.length!! <6){
                        Toast.makeText(this,"Enter 6 digit Length Password",Toast.LENGTH_SHORT).show()
                    }
                    if(binding!!.createAccPhoneNoBtn.text.toString().length !=10){
                        Toast.makeText(this,"PhoneNo needs to be 10 digit",Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this,"Please input Details Properly",Toast.LENGTH_SHORT).show()
            }
        }



    }
        fun checkEmailValidation(checkEmail : String): Boolean {
            emailStatus = checkEmail.matches(emailFormat.toRegex())
            return emailStatus
        }
}