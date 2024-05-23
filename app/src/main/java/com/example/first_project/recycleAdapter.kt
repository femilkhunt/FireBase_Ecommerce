package com.example.first_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class recycleAdapter(var productsummary: ArrayList<productSummary>) :
    RecyclerView.Adapter<recycleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycleAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.define_recycle_view,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: recycleAdapter.ViewHolder, position: Int) {
        var data = productsummary[position]

//        Glide.with(this)
        holder.heading.text = productsummary[position].productheading
        holder.price.text = productsummary[position].productprice

    }

    override fun getItemCount(): Int {
        return productsummary.size
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        var img = itemview.findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
        var heading = itemview.findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
        var price = itemview.findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)
    }

}















//class viewAdapter(var context: Context, var productSummary: productSummary) : PagerAdapter(){
//
//    var layoutInflater : LayoutInflater? = null
//
//    @SuppressLint("MissingInflatedId")
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = LayoutInflater.from(container.context)
//        var view = layoutInflater!!.inflate(R.layout.home_screen_layout,container,false)
//        var img = view.findViewById<AppCompatImageView>(R.id.homeScreenProductImage)
//        var heading = view.findViewById<AppCompatTextView>(R.id.homeScreenProductHeading)
//        var price = view.findViewById<AppCompatTextView>(R.id.homeScreenProductPrice)
//
//       Glide.with(context).load(productSummary.productimg.toString()).into(img)
//
//
//        return view
//    }
//
//    override fun getCount(): Int {
//        return
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//
//    }
//
//
//}