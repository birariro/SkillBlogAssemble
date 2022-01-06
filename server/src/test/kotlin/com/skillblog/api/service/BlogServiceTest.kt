package com.skillblog.api.service

import com.skillblog.api.domain.BlogItemRepo
import com.skillblog.api.domain.RssEntity
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.persistence.Transient

@SpringBootTest
internal class BlogServiceTest {

    @Autowired
    lateinit var blogService: BlogService
    @Autowired
    lateinit var blogItemRepo: BlogItemRepo
    @Test
    fun getBlogData() {
        blogService.test()
    }

    @Test
    @Transient
    fun `파싱할 대상을 조회하여 파싱한다`(){
        var dummy = mutableListOf<RssEntity>().apply {
            add(RssEntity(0L,"배달의 민족","https://techblog.woowahan.com/feed/"))
            add(RssEntity(0L,"카카오","https://tech.kakao.com/feed/"))
        }
        for (rssEntity in dummy) {
            val blogDatas = blogService.getBlogData(rssEntity.company, rssEntity.rssUrl)
            for (blogData in blogDatas) {
                println("blogData = ${blogData.title}")
            }
        }
    }

}