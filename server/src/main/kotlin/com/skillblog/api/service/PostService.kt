package com.skillblog.api.service

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import com.skillblog.api.domain.blog.BlogEntity
import com.skillblog.api.domain.rss.RssEntity
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URI
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*


@Service
class SiteService {

    fun getBlogData(company: String , rssUrl:String) {
        val rssUrl = rssUrl
        var result  = mutableListOf<BlogEntity>()
        try {
            val feedUrl = URL(rssUrl)
            val input = SyndFeedInput()
            var feed: SyndFeed = input.build(XmlReader(feedUrl))
            println("RSS title: " + feed.title)
            println("RSS author: " + feed.author)
            val entries: List<SyndEntry> = feed.entries
            for (i in entries.indices) {
                val entry: SyndEntry = entries[i]

                val title = entry.title
                val description = entry?.description?.value ?: ""

                val author = entry.author
                val link = entry.link
                println("company $company")
                println("title $title")
                println("author $author")
                println("link $link")
                break

            }
        } catch (e: IllegalArgumentException) {
            // ...
        } catch (e: FeedException) {
            // ...
        }  catch (e: IOException){

        }

    }


    fun test() {
        getBlogData("배달의 민족","https://techblog.woowahan.com/feed/") //배민

        println("END END ")
        //getBlogData("카카오","https://tech.kakao.com/feed/") //카카오

    }
}

fun main() {
    SiteService().getBlogData("배달의 민족","https://techblog.woowahan.com/feed/")
    SiteService().getBlogData("카카오","https://tech.kakao.com/feed/")
    SiteService().getBlogData("왓차","https://medium.com/feed/watcha")
    SiteService().getBlogData("마켓컬리","http://thefarmersfront.github.io/feed.xml")
    SiteService().getBlogData("NHN","https://meetup.toast.com/rss")
    SiteService().getBlogData("당근마켓","https://medium.com/feed/daangn")
    SiteService().getBlogData("라인","https://engineering.linecorp.com/ko/feed/")
    SiteService().getBlogData("네이버","https://d2.naver.com/d2.atom")
    SiteService().getBlogData("이스트소프트","https://blog.est.ai/feed/")
    SiteService().getBlogData("딜리버리 코리아","https://techblog.yogiyo.co.kr/feed")

}