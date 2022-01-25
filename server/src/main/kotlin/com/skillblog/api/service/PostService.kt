package com.skillblog.api.service

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import com.skillblog.api.domain.blog.BlogEntity
import com.skillblog.api.domain.post.PostEntity
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
class PostService {

    fun getPostData(company: String , code:Int, rssUrl:String): List<PostEntity> {
        val rssUrl = rssUrl
        var postEntityList  = mutableListOf<PostEntity>()
        try {
            val feedUrl = URL(rssUrl)
            val input = SyndFeedInput()
            var feed: SyndFeed = input.build(XmlReader(feedUrl))
            val entries: List<SyndEntry> = feed.entries
            for (i in entries.indices) {
                val entry: SyndEntry = entries[i]

                val title = entry.title
                val link = entry.link

                val postEntity = PostEntity(id = 0, company = company,code = code, title = title, link = link)
                postEntityList.add(postEntity)

            }
            return postEntityList
        } catch (e: Exception) {
        }
        return postEntityList
    }

}
