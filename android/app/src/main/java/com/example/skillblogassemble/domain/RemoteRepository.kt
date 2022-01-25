package com.example.skillblogassemble.domain

import android.graphics.Color
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.datasource.SampleDataSource
import com.example.skillblogassemble.domain.model.BlogItem
import com.example.skillblogassemble.domain.model.SampleEntity

class RemoteRepository {

    fun getBlogItem() : List<BlogItem>{
        val dataList = ArrayList<BlogItem>().apply {
            add(
                BlogItem(
                "Naver",
                "지식iN 앱을 Flutter로\n 개발하는 이유",
                "할만했다" ,
                Color.parseColor("#0DC75B"),
                R.drawable.naver,"https://d2.naver.com/helloworld/3384599")
            )

            add(
                BlogItem("Coupang",
                "QA testing for\n microservices",
                "왜 영어?" ,
                Color.parseColor("#A2180B"),
                R.drawable.coupang,
                "https://medium.com/coupang-engineering/qa-mock-system-8b50c201906d")
            )

            add(
                BlogItem("우아한 형제들",
                "외부 시스템 장애에 대처하는 우리의 자세",
                "좋은 자세" ,
                Color.parseColor("#28B8B3"),
                R.drawable.woowabros,
                "https://techblog.woowahan.com/6447/")
            )

            add(
                BlogItem("당근마켓",
                "모듈화하고 Needle 적용해보기",
                "당신 근처" ,
                Color.parseColor("#F27B31"),
                R.drawable.daangn,
                "https://medium.com/daangn/%EB%AA%A8%EB%93%88%ED%99%94%ED%95%98%EA%B3%A0-needle-%EC%A0%81%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0-bd5e9f3c450b")
            )
        }
        return dataList
    }

    suspend fun getSampleAPI() : SampleEntity {
        return RetrofitClient.getInstance().create(SampleDataSource::class.java).getEntity()
    }
}