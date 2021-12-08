package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.model.BlogItem

class MainActivity : AppCompatActivity() {

    val viewPager : ViewPager2  by lazy { findViewById(R.id.viewPager) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val items = viewModel.getPostItemList()
        var adapter = ViewPagerAdapter(items)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer(SliderTransformer(3))

    }
}