package com.skillblog.api.domain

import com.skillblog.api.domain.rss.RssEntity
import com.skillblog.api.domain.rss.RssReop
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.persistence.Transient

@DataJpaTest
@ExtendWith(SpringExtension::class)
internal class RssEntityTest {

    @Autowired
    lateinit var rssReop: RssReop

    @Test
    @Transient
    fun `객체를 저장하고 출력해본다` () {

        val rssEntity1 = RssEntity(0L,"배달의 민족","https://techblog.woowahan.com/feed/")
        val rssEntity2 = RssEntity(0L,"카카오","https://tech.kakao.com/feed/")
        rssReop.save(rssEntity1)
        rssReop.save(rssEntity2)

        val findAll = rssReop.findAll()

        for(item in findAll){
            println("item = ${item.company}")
        }
        Assertions.assertEquals(rssEntity1.company,findAll.get(0).company)
        Assertions.assertEquals(rssEntity2.company,findAll.get(1).company)

    }

}