package com.skillblog.api.domain.blog

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogRepo :  JpaRepository<BlogEntity,Long>{
}