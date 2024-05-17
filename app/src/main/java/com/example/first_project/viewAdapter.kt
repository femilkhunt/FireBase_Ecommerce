package com.example.first_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class viewAdapter(var homeScreen: homeScreenActivity, var productSummary: productSummary) : PagerAdapter(){

    var layoutInflater : LayoutInflater? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(homeScreen)
        var view = layoutInflater!!.inflate(R.layout.,container,false)
        var img = view.findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var heading = view.findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
        var price = view.findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)

        img.setImageResource(productSummary.ge)


        return view
    }

    override fun getCount(): Int {

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

    }


}