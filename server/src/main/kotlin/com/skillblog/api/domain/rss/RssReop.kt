package com.skillblog.api.domain.rss

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RssReop :JpaRepository<RssEntity,Long>{
}