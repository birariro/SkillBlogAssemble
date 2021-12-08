package com.example.skillblogassemble.presenter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.RecyclerView
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.model.BlogItem

class ViewPagerAdapter(private val items:List<BlogItem>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    inner class ViewPagerHolder(var view : View) : RecyclerView.ViewHolder(view){
        var item_ground : ConstraintLayout = view.findViewById(R.id.item_ground)
        var item_company : TextView = view.findViewById(R.id.item_company)
        var item_title : TextView = view.findViewById(R.id.item_title)
        var item_context : TextView = view.findViewById(R.id.item_context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewPagerHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)

        return ViewPagerHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.item_ground.setBackgroundColor(items[position].Color)
        holder.item_company.text = items[position].company
        holder.item_title.text = items[position].title
        holder.item_context.text = items[position].content


    }
}