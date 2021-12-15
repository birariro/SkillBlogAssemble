package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.RemoteRepository
import com.example.skillblogassemble.domain.model.BlogItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val remoteRepository: RemoteRepository): ViewModel() {


    fun getViewPagerDataList() : List<BlogItem>{
       return remoteRepository.getBlogItem()
    }

    fun repositoryHello(): String{
        return remoteRepository.hello()
    }
}