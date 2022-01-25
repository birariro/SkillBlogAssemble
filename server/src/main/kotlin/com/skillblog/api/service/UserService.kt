package com.skillblog.api.service

import com.skillblog.api.common.ValidData
import com.skillblog.api.domain.user.User
import com.skillblog.api.domain.user.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepo: UserRepo
    fun login(id:String,pwd:String) : Boolean{
        val valid = ValidData()
        if(! valid.isUserIdValid(id) || !valid.isUserPwdValid(pwd) ){
            return false
        }

        val findUser = userRepo.findByIdOrNull(id) ?: return false
        if(findUser.pwd == pwd){
            return true
        }
        return false
    }

    fun createUser(user:User):Boolean{
        val valid = ValidData()
        if(! valid.isUserIdValid(user.id) || !valid.isUserPwdValid(user.pwd) || !valid.isUserEmailValid(user.email)){
            return false
        }
        if(userRepo.findByIdOrNull(user.id) != null){
            return false
        }
        userRepo.save(user)
        userRepo.findByIdOrNull(user.id) ?: return false

        return true

    }
}