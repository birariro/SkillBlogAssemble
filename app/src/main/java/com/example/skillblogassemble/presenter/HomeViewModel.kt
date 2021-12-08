package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.skillblogassemble.domain.model.BlogItem

class HomeViewModel: ViewModel() {


    fun getViewPagerDataList() : ArrayList<BlogItem>{
        val dataList = ArrayList<BlogItem>().apply {
            add(BlogItem("naver","플러터 사용기","할만했다" ,  Color.parseColor("#1DDB16")))
            add(BlogItem("쿠팡","쿠팡 뭔가를 함","뭔가를 했다" ,  Color.parseColor("#FF0000")))
            add(BlogItem("페이스북","페이스북 이름 바꿈","블록체인" ,  Color.parseColor("#0054FF")))
            add(BlogItem("당근마켓","당근 근처 있음","이름 이유" ,  Color.parseColor("#FF5E00")))
        }
        return dataList
    }
}