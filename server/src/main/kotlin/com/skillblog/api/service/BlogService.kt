package com.skillblog.api.service

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import com.skillblog.api.controller.dto.BlogItemResponse
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URL



@Service
class BlogService {

    fun getBlogData(company: String , rssUrl:String) : BlogItemResponse{
        val rssUrl = rssUrl

        try {
            val feedUrl = URL(rssUrl)
            val input = SyndFeedInput()
            var feed: SyndFeed = input.build(XmlReader(feedUrl))
            println("RSS title: " + feed.title)
            println("RSS author: " + feed.author)
            val entries: List<SyndEntry> = feed.entries
            for (i in entries.indices) {
                val entry: SyndEntry = entries[i]
                //                System.out.println("--- Entry " + i);
                println("title > "+entry.title) //제목
                println("author > "+entry.author) //작성자
                println("description.value > "+entry.description.value) //본문 내용 조금
                println("entry.link > "+entry.link) //링크
                //println("entry.categories > "+entry.categories)
                println("entry.comments > "+entry.comments)
                println("entry.publishedDate > "+entry.publishedDate) //업로드 날짜
                //println("entry.contents > "+entry.contents) //본문 내용

                var item = BlogItemResponse(company = company,
                        title = entry.title,
                        description = entry.description.value,
                        author = entry.author,
                        link = entry.link,
                        data = entry.publishedDate)
                return item
            }
        } catch (e: IllegalArgumentException) {
            // ...
        } catch (e: FeedException) {
            // ...
        }  catch (e: IOException){

        }
        throw Exception()
    }
    fun test() {
        getBlogData("배달의 민족","https://techblog.woowahan.com/feed/") //배민

        println("END END ")
        getBlogData("카카오","https://tech.kakao.com/feed/") //카카오


    }
}