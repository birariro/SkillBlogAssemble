package com.example.skillblogassemble.presenter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.example.skillblogassemble.R

class ViewPagerAdapter(private val items:List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    inner class ViewPagerHolder(var view : View) : RecyclerView.ViewHolder(view){
        var imageView : ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewPagerHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)
        return ViewPagerHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.imageView.setBackgroundColor(items[position])
    }
}