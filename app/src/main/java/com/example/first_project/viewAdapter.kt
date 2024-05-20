package com.example.first_project

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class viewAdapter(var homeScreen: homeScreenActivity, var productSummary: productSummary) : PagerAdapter(){

    var layoutInflater : LayoutInflater? = null

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(homeScreen)
        var view = layoutInflater!!.inflate(R.layout.home_screen_layout,container,false)
        var img = view.findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var heading = view.findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
        var price = view.findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)

       Glide.with(Context)


        return view
    }

    override fun getCount(): Int {
        return
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

    }


}