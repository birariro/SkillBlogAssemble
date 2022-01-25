package com.skillblog.api.service

import com.skillblog.api.domain.blog.BlogRepo
import com.skillblog.api.domain.rss.RssEntity
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.Transient

//@SpringBootTest
internal class BlogServiceTest {

//    @Autowired
//    lateinit var blogService: BlogService

    val blogService = BlogService()
    @Autowired
    lateinit var blogRepo: BlogRepo
    //@Test
    fun getBlogData() {
        blogService.test()
    }

    @Test
    @Transient
    fun `파싱할 대상을 조회하여 파싱한다`(){
        val dummy = dummyBlogList()
        for (rssEntity in dummy) {
            val blogDatas = blogService.getBlogData(rssEntity.company, rssEntity.rssUrl)
            for (blogData in blogDatas) {
                println("blogData = ${blogData.title}")
            }
        }
    }
    @Test
    fun `파싱할 대상이 정상적으로 파싱되는지 확인한다`(){
        val target = 0
        val dummy = dummyBlogList().get(target)
        val blogDatas = blogService.getBlogData(dummy.company, dummy.rssUrl)
        for (blogData in blogDatas) {
            println("\n\ntarget $target ################################################")
            println("blogData title = ${blogData.title}")
            println("blogData author = ${blogData.author}")
            println("blogData link = ${blogData.link}")
            println("blogData imageLink = ${blogData.imageLink}")
            println("blogData date= ${blogData.date}")
            println("blogData description len = ${blogData.description.length}")

        }
    }


    private fun dummyBlogList(): List<RssEntity>{
        var dummy = mutableListOf<RssEntity>().apply {
            //add(RssEntity(0L,"배달의 민족","https://techblog.woowahan.com/feed/"))
            //add(RssEntity(0L,"카카오","https://tech.kakao.com/feed/"))
            //add(RssEntity(0L,"왓차","https://medium.com/feed/watcha")) //안됨
            //add(RssEntity(0L,"마켓컬리","http://thefarmersfront.github.io/feed.xml"))//안됨
            //add(RssEntity(0L,"NHN","https://meetup.toast.com/rss"))
            //add(RssEntity(0L,"당근마켓","https://medium.com/feed/daangn"))
            //add(RssEntity(0L,"라인","https://engineering.linecorp.com/ko/feed/"))
            //add(RssEntity(0L,"네이버","https://d2.naver.com/d2.atom"))
            add(RssEntity(0L,"이스트소프트","https://blog.est.ai/feed/"))
            //add(RssEntity(0L,"딜리버리 코리아","https://techblog.yogiyo.co.kr/feed"))

        }
        return dummy
    }


}