package com.skillblog.api.common.batch.tasks

import com.skillblog.api.domain.site.SiteEntity
import com.skillblog.api.domain.site.SiteRepo
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping


class SiteTask : Tasklet{
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        println("execute task!!")
        //initSite()
        return RepeatStatus.FINISHED
    }
//    @Autowired
//    lateinit var siteRepo: SiteRepo
//
//    @GetMapping
//    fun initSite(){
//        val siteList = mutableListOf<SiteEntity>().apply {
//            add(SiteEntity(0L,"배달의 민족","https://techblog.woowahan.com/feed/"))
//            add(SiteEntity(0L,"카카오","https://tech.kakao.com/feed/"))
//            add(SiteEntity(0L,"왓차","https://medium.com/feed/watcha"))
//            add(SiteEntity(0L,"마켓컬리","http://thefarmersfront.github.io/feed.xml"))
//            add(SiteEntity(0L,"NHN","https://meetup.toast.com/rss"))
//            add(SiteEntity(0L,"당근마켓","https://medium.com/feed/daangn"))
//            add(SiteEntity(0L,"라인","https://engineering.linecorp.com/ko/feed/"))
//            add(SiteEntity(0L,"네이버","https://d2.naver.com/d2.atom"))
//            add(SiteEntity(0L,"이스트소프트","https://blog.est.ai/feed/"))
//            add(SiteEntity(0L,"딜리버리 코리아","https://techblog.yogiyo.co.kr/feed"))
//        }
//
//        for (siteEntity in siteList) {
//            siteRepo.save(siteEntity)
//        }
//
//    }

}