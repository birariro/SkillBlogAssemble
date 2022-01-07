package com.skillblog.api.service

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import com.skillblog.api.domain.blog.BlogEntity
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URI
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*


@Service
class BlogService {

    fun getBlogData(company: String , rssUrl:String) : List<BlogEntity>{
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
                //                System.out.println("--- Entry " + i);
              //  println("title > "+entry.title) //제목
               // println("author > "+entry.author) //작성자
               // println("description.value > "+entry.description.value) //본문 내용 조금
               // println("entry.link > "+entry.link) //링크
                //println("entry.categories > "+entry.categories)
               // println("entry.comments > "+entry.comments)
               // println("entry.publishedDate > "+entry.publishedDate) //업로드 날짜
                //println("entry.contents > "+entry.contents) //본문 내용

                //println("imageUrle > "+imageUrl) //이미지
                val title = entry.title
                val description = entry?.description?.value ?: ""

                val author = entry.author
                val link = entry.link
                val date = entry.publishedDate ?: Date()
                val imageUrl = getContentsImage(entry.link,entry.contents)

                var blogEntity = BlogEntity(id = 0L,title =title,description = description,
                author = author,link =link ,date = date,imageLink = imageUrl)
//                var item = BlogItemResponse(company = company,
//                        title = entry.title,
//                        description = entry.description.value,
//                        author = entry.author,
//                        link = entry.link,
//                        data = entry.publishedDate)
                result.add(blogEntity)
            }
        } catch (e: IllegalArgumentException) {
            // ...
        } catch (e: FeedException) {
            // ...
        }  catch (e: IOException){

        }
        return result
    }
    private fun getContentsImage(link:String, contents:List<com.rometools.rome.feed.synd.SyndContent>) : String{
        //todo 예외처리 하셈
        if(contents.isEmpty()){
            // todo 안의 내용이없는경우 url로 접근해서 이미지를 가지고와야한다.
            val client = HttpClient.newBuilder().build();
            val request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build()
            val response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return getImageUrl(response.body())
        }
        // contents 안의 이미지를 파싱한다.
        for (content in contents){
            return getImageUrl(content.value)
        }
        return ""
    }
    private fun getImageUrl(content:String) : String{
        return try{
            val targetChar = "img src=\""
            val startIndex = content.indexOf(targetChar) + targetChar.length
            val endIndex = content.indexOf("\"", startIndex)
            val result = content.substring(startIndex, endIndex)
            result
        }catch (e:Exception){
            ""
        }

    }
    fun test() {
        getBlogData("배달의 민족","https://techblog.woowahan.com/feed/") //배민

        println("END END ")
        //getBlogData("카카오","https://tech.kakao.com/feed/") //카카오

    }
}