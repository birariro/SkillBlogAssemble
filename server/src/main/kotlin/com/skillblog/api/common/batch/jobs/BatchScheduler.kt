package com.skillblog.api.common.batch.jobs

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionException
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.time.LocalDateTime

@Component
class BatchScheduler {
    @Autowired
    lateinit var batchConfig: BatchConfig

    @Autowired
    lateinit var job: Job
    @Autowired
    lateinit var jobLauncher: JobLauncher


    //@Scheduled(fixedDelay = 5 * 1000L)   // 5초마다 실행
    @Scheduled(fixedDelay = 5000 * 1000L)
    fun executeJob() {
        try {

            jobLauncher.run(
                    batchConfig.batchJob(),
                    JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters() // job parameter 설정
            )
        } catch (ex: JobExecutionException) {
            println(ex.message)
            ex.printStackTrace()
        }
    }

}