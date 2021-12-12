package com.skillblog.api.service

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URL



@Service
class BlogService {
    fun test() {
        val rssUrl = "https://j-k4keye.tistory.com/rss"

        try {
            val feedUrl = URL(rssUrl)
            val input = SyndFeedInput()
            var feed: SyndFeed = input.build(XmlReader(feedUrl))
            System.out.println("RSS title: " + feed.getTitle())
            System.out.println("RSS author: " + feed.getAuthor())
            val entries: List<*> = feed.getEntries()
            for (i in entries.indices) {
                val entry: SyndEntry = entries[i] as SyndEntry
                //                System.out.println("--- Entry " + i);
                System.out.println(entry.getTitle())
                //                System.out.println(entry.getAuthor());
//                System.out.println(entry.getDescription().getValue());
//                System.out.println(entry.getLink());
            }
        } catch (e: IllegalArgumentException) {
            // ...
        } catch (e: FeedException) {
            // ...
        }  catch (e: IOException){

        }
    }
}