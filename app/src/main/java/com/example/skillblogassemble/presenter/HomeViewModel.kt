package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.skillblogassemble.domain.model.BlogItem

class HomeViewModel: ViewModel() {


    fun getViewPagerDataList() : ArrayList<BlogItem>{
        val dataList = ArrayList<BlogItem>().apply {
            add(BlogItem("Naver","지식iN 앱을 Flutter로 개발하는 이유","할만했다" ,  Color.parseColor("#0DC75B")))
            add(BlogItem("Coupang","QA testing for microservices","왜 영어?" ,  Color.parseColor("#A2180B")))
            add(BlogItem("우아한 형제들","외부 시스템 장애에 대처하는 우리의 자세","좋은 자세" ,  Color.parseColor("#28B8B3")))
            add(BlogItem("당근마켓","모듈화하고 Needle 적용해보기","당신 근처" ,  Color.parseColor("#F27B31")))
        }
        return dataList
    }
}