package com.skillblog.api.domain.site

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class SiteEntity (
       @Id @GeneratedValue
       val id:Long,
       val company:String,
       val link :String
)