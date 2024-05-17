package com.example.first_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.first_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainScreenNextBtn.setOnClickListener(){
            startActivity(Intent(this,createAccActivity::class.java))
        }

        binding.mainScreenLoginBtn.setOnClickListener(){
            startActivity(Intent(this,LoginAccActivity::class.java))
        }
    }
}