package com.example.first_project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Context
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Context as Context1

class homeScreenActivity : AppCompatActivity() {


        lateinit var viewPager : ViewPager
        lateinit var adapter : viewAdapter
        lateinit var auth : FirebaseAuth
        lateinit var database : DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen_layout)

        auth = Firebase.auth
        database = Firebase.database.reference

        var productImg = findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var productHeading = findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
        var productPrice = findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)


        var productSummary = productSummary(productImg.toString(),productHeading.toString(),productPrice.toString())

    adapter = viewAdapter(this,productSummary)

        database.addChildEventListener(object : ValueEventListener, ChildEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                   var img : String = snapshot.child("posts").child("0").child("imageUrl").getValue().toString()
                   productHeading.setText(snapshot.child("posts").child("0").child("title").getValue().toString())
                   productPrice.setText(snapshot.child("posts").child("0").child("price").getValue().toString())

                Glide.with(Context).load(img).into(productImg)
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}