package com.example.first_project

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.first_project.databinding.PasswordLayoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PasswordActivity : AppCompatActivity() {

    var emailFromLogin : String? = null
    var binding : PasswordLayoutBinding? = null
    lateinit var auth : FirebaseAuth
    var progressdialog : Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PasswordLayoutBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = Firebase.auth
        emailFromLogin = intent.extras?.getString("email")

        binding!!.passAccNextBtn.setOnClickListener(){
            progressBar()
            if(binding!!.passAccPassword.text?.length!! >=6){
                auth.signInWithEmailAndPassword(emailFromLogin.toString(), binding!!.passAccPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"SuccessFully Login With FireBase",Toast.LENGTH_SHORT).show()
                        progressdialog?.dismiss()
                        startActivity(Intent(this,homeScreenActivity::class.java))
                    }
                }.addOnFailureListener {
                        progressdialog?.dismiss()
                        Toast.makeText(this,"UnSuccessFull Login Try Again",Toast.LENGTH_SHORT).show()
                }
            }else{
                        progressdialog?.dismiss()
                        Toast.makeText(this,"Password is Atleast 6 Digit Long",Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun progressBar(){
        progressdialog = Dialog(this)
        progressdialog!!.setContentView(R.layout.progressbar)
        progressdialog!!.setCancelable(false)
        progressdialog!!.show()
    }
}