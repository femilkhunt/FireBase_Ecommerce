package com.example.first_project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.ViewPager

class homeScreenActivity : AppCompatActivity() {


        lateinit var viewPager : ViewPager
        lateinit var viewAdapter : viewAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen_layout)

        var productImg = findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var productHeading = findViewById<AppCompatImageView>(R.id.homeScreenProductHeading)
        var productPrice = findViewById<AppCompatImageView>(R.id.homeScreenProductPrice)


        var productSummary = productSummary(productImg.toString(),productHeading.toString(),productPrice.toString())

    viewAdapter = viewAdapter()

    }
}