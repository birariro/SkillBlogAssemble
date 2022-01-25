package com.skillblog.api

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableBatchProcessing// 배치 기능 활성화
@EnableScheduling //스케줄러 기능 활성화
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
