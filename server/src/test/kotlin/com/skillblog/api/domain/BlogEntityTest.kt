package com.skillblog.api.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import javax.persistence.Transient

@DataJpaTest
@ExtendWith(SpringExtension::class)
internal class BlogItemTest {

    @Autowired
    lateinit var blogItemRepo :BlogItemRepo


    @Test
    @Transient
    fun `객체를 저장하고 출력해본다` () {
        var blogitem = BlogItem(id = 0L,"titleSample", description = "decSample", author = "authorSample",link = "linkSample" ,date = Date() ,imageLink = "")
        var blogitem2 = BlogItem(id = 0L,"titleSample2", description = "decSample2", author = "authorSample2",link = "linkSample2" ,date = Date() ,imageLink = "")

        blogItemRepo.save(blogitem)
        blogItemRepo.save(blogitem2)

        val findAll = blogItemRepo.findAll()

        Assertions.assertEquals(blogitem.title,findAll.get(0).title)
        Assertions.assertEquals(blogitem2.title,findAll.get(1).title)

    }


}