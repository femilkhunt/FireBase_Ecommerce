package com.example.first_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.first_project.databinding.LoginActivityBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginAccActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    val emailFormat : String = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    var emailStatus : Boolean = false
    var binding : LoginActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = Firebase.auth

        binding!!.loginAccNextBtn.setOnClickListener(){
                emailStatus = checkEmailValidation(binding!!.loginAccEmailBtn.text.toString())

            if (binding!!.loginAccEmailBtn.text?.length!! <=0){
                Toast.makeText(this,"Enter Proper Data",Toast.LENGTH_SHORT).show()
            }
            else if(emailStatus == true){
                startActivity(Intent(this, PasswordActivity::class.java).putExtra("email", binding!!.loginAccEmailBtn.text.toString()))
            }
            else{
                Toast.makeText(this,"Enter proper Email",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkEmailValidation(checkEmail: String): Boolean {
        emailStatus = checkEmail.matches(emailFormat.toRegex())
        return emailStatus
    }
}