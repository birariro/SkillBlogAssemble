package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.model.BlogItem

class MainActivity : AppCompatActivity() {

    val viewPager : ViewPager2  by lazy { findViewById(R.id.viewPager) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<BlogItem>().apply {
            add(BlogItem("naver","플러터 사용기","할만했다" ,  Color.parseColor("#1DDB16")))
            add(BlogItem("쿠팡","쿠팡 뭔가를 함","뭔가를 했다" ,  Color.parseColor("#FF0000")))
            add(BlogItem("페이스북","페이스북 이름 바꿈","블록체인" ,  Color.parseColor("#0054FF")))
            add(BlogItem("당근마켓","당근 근처 있음","이름 이유" ,  Color.parseColor("#FF5E00")))
        }
        var adapter = ViewPagerAdapter(items)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer(SliderTransformer(3))

    }
}