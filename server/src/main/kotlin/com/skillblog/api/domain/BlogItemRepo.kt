package com.skillblog.api.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogItemRepo :  JpaRepository<BlogItem,Long>{
}