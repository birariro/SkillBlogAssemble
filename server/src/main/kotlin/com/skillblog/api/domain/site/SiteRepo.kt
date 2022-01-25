package com.skillblog.api.domain.site

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SiteRepo :JpaRepository<SiteEntity,Long>{
}