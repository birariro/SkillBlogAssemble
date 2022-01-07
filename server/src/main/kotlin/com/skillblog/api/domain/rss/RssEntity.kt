package com.skillblog.api.domain.rss

import javax.persistence.*

@Entity
class RssEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(nullable = false)
        val company:String,
        @Column(columnDefinition = "TEXT", nullable = false)
        val rssUrl :String
        )