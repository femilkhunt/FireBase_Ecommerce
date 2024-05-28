package com.example.first_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ChildEventListener as ChildEventListener1

class homeScreenActivity : AppCompatActivity() {


//    lateinit var viewPager: ViewPager
//    lateinit var adapter: viewAdapter
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen_layout)

        auth = Firebase.auth
        database = Firebase.database.reference

        var productImg = findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var productHeading = findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
        var productPrice = findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)

        var productsummaray : ArrayList<productSummary> = ArrayList()
        var dataForAdapter = recycleAdapter(productsummaray)

        val recycleview = findViewById<RecyclerView>(R.id.homeScreenRecycleView)
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = dataForAdapter


        val dataTaker = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                    productsummaray.addAll(productsummaray)
//                snapshot.child("posts").get
                Toast.makeText(this@homeScreenActivity,"YessssssssssssYesss",Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@homeScreenActivity,"Noooooo",Toast.LENGTH_SHORT).show()

            }

        }

       database.child("posts").get().addOnSuccessListener {
//           productsummaray = it.children
       }












//        database.child("posts").get().addOnSuccessListener {
//            Toast.makeText(this,"Yesss",Toast.LENGTH_SHORT).show()
//           database.addChildEventListener(object : ChildEventListener{
//               override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
//                   TODO("Not yet implemented")
//               }
//
//               override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
//                   var img : String = snapshot.child("posts").child("0").child("imageUrl").getValue().toString()
//                   productHeading.setText(snapshot.child("posts").child("0").child("title").getValue().toString())
//                   productPrice.setText(snapshot.child("posts").child("0").child("price").getValue().toString())
//
//                   productsummaray.addAll()
//               }
//
//               override fun onChildRemoved(snapshot: DataSnapshot) {
//                   TODO("Not yet implemented")
//               }
//
//               override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
//                   TODO("Not yet implemented")
//               }
//
//               override fun onCancelled(error: DatabaseError) {
//                   TODO("Not yet implemented")
//               }
//
//           }
//        }

//        adapter = viewAdapter(this, productSummary)


//        database.addChildEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                   var img : String = snapshot.child("posts").child("0").child("imageUrl").getValue().toString()
//                   productHeading.setText(snapshot.child("posts").child("0").child("title").getValue().toString())
//                   productPrice.setText(snapshot.child("posts").child("0").child("price").getValue().toString())
//
//                Glide.with(this@homeScreenActivity).load(img).into(productImg)
//            }
//
//            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onChildRemoved(snapshot: DataSnapshot) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })

    }
}