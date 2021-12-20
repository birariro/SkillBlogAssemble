package com.example.skillblogassemble.presenter

import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillblogassemble.R
import com.example.skillblogassemble.domain.RemoteRepository
import com.example.skillblogassemble.domain.model.BlogItem
import com.example.skillblogassemble.domain.model.SampleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val remoteRepository: RemoteRepository): ViewModel() {


    fun getViewPagerDataList() : List<BlogItem>{
       return remoteRepository.getBlogItem()
    }

    fun getSampleEntity() {
        viewModelScope.launch {
            val data = remoteRepository.getSampleAPI()
            println("getSampleAPI = ${data}")
        }
    }
}