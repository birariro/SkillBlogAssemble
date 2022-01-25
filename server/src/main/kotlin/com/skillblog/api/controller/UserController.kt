package com.skillblog.api.controller

import com.skillblog.api.common.response.ResponseService
import com.skillblog.api.common.response.result.body.CommonResult
import com.skillblog.api.common.response.result.body.HatroasDto
import com.skillblog.api.common.response.result.hader.ErrorCode
import com.skillblog.api.controller.dto.LoginDto
import com.skillblog.api.domain.site.SiteRepo
import com.skillblog.api.domain.user.User
import com.skillblog.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var loginService: UserService

    @Autowired
    lateinit var responseService: ResponseService

    @Autowired
    lateinit var siteRepo: SiteRepo
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto):CommonResult{
        val result = loginService.login(loginDto.id,loginDto.pwd)
        if(! result) responseService.getFailResult(ErrorCode.LOGIN_FALUD)


        val links = mutableListOf<HatroasDto>().apply {
            add(HatroasDto("home","http://localhost:8080/home"))
            add(HatroasDto("setting","http://localhost:8080/setting"))
            add(HatroasDto("account","http://localhost:8080/account"))
        }

        val data = mutableListOf<String>()
        val siteEntityList = siteRepo.findAll()
        for (siteEntity in siteEntityList) {
            data.add(siteEntity.company)
        }


        val responseData = mutableMapOf<String,Any>().apply {
            put("targets",data)
            put("links",links)
        }

        return responseService.getSingleResult(responseData)

    }

    @PostMapping
    fun createUser(@RequestBody user:User) :CommonResult{
        val result = loginService.createUser(user)
        if(result){
            return responseService.getSuccessResult()
        }
        return responseService.getFailResult(ErrorCode.DB)
    }
}