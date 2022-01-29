package com.skillblog.api.controller

import com.skillblog.api.domain.post.PostRepo
import com.skillblog.api.domain.site.SiteEntity
import com.skillblog.api.domain.site.SiteRepo
import com.skillblog.api.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RestController
@RequestMapping("/init")
class InitController {

    @Autowired
    lateinit var siteRepo: SiteRepo

    @Autowired
    lateinit var postRepo: PostRepo
    @Autowired
    lateinit var postService: PostService
    @GetMapping
    fun init(){
        initSite()
        //initPost()
    }

    @Transactional
    private fun initSite(){
        val siteList = mutableListOf<SiteEntity>().apply {
            add(SiteEntity(1001,"배달의 민족","https://techblog.woowahan.com/feed/"))
            add(SiteEntity(1002,"카카오","https://tech.kakao.com/feed/"))
            add(SiteEntity(1003,"왓차","https://medium.com/feed/watcha"))
            add(SiteEntity(1004,"마켓컬리","http://thefarmersfront.github.io/feed.xml"))
            add(SiteEntity(1005,"NHN","https://meetup.toast.com/rss"))
            add(SiteEntity(1006,"당근마켓","https://medium.com/feed/daangn"))
            add(SiteEntity(1007,"라인","https://engineering.linecorp.com/ko/feed/"))
            add(SiteEntity(1008,"네이버","https://d2.naver.com/d2.atom"))
            add(SiteEntity(1009,"이스트소프트","https://blog.est.ai/feed/"))
            add(SiteEntity(1010,"딜리버리 코리아","https://techblog.yogiyo.co.kr/feed"))
        }

        for (siteEntity in siteList) {
            val postList = postService.getPostData(siteEntity.company,siteEntity.code,siteEntity.link)

            for (postEntity in postList) {

                siteEntity.addPost(postEntity)
                postRepo.save(postEntity)
            }

            siteRepo.save(siteEntity)
        }
    }

    private fun initPost(){
        val siteList = siteRepo.findAll()
        for (siteEntity in siteList) {
            val postList = postService.getPostData(siteEntity.company,siteEntity.code,siteEntity.link)

            for (postEntity in postList) {
                postRepo.save(postEntity)
            }
        }

    }
}