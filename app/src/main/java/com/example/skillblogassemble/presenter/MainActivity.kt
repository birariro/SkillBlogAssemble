package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.skillblogassemble.R

class MainActivity : AppCompatActivity() {

    val viewPager : ViewPager2  by lazy { findViewById(R.id.viewPager) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<Int>().apply {
            add(Color.parseColor("#ffff00"))
            add(Color.parseColor("#5fdbdb"))
            add(Color.parseColor("#45afdb"))
            add(Color.parseColor("#5fdbdb"))
            add(Color.parseColor("#45afdb"))
        }
        var adapter = ViewPagerAdapter(items)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer(SliderTransformer(3))

    }
}