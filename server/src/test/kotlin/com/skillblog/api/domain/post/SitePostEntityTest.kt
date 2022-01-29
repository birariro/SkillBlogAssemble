package com.skillblog.api.domain.post

import com.skillblog.api.domain.site.SiteEntity
import com.skillblog.api.domain.site.SiteRepo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SitePostEntityTest{
    @Autowired
    lateinit var siteRepo: SiteRepo
    @Autowired
    lateinit var postRepo: PostRepo

    @Test
    fun sitePost(){
        var siteEntity = SiteEntity(code = 9999, company = "내회사",link = "http:/test.com")
        var postEntity = PostEntity(title = "타이틀",postLink = "post링크")
        siteEntity.addPost(postEntity)
        siteRepo.save(siteEntity)
        postRepo.save(postEntity)
        val findAll = siteRepo.findAll()
        for (siteEntity in findAll) {
            println("siteEntity ${siteEntity}")
        }
        val findAll1 = postRepo.findAll()
        for (siteEntity in findAll1) {
            println("post ${siteEntity}")
        }

    }
}