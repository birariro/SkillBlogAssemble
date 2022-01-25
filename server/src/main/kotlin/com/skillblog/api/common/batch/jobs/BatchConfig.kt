package com.skillblog.api.common.batch.jobs

import com.skillblog.api.common.batch.tasks.SiteTask
import com.skillblog.api.domain.site.SiteEntity
import com.skillblog.api.domain.site.SiteRepo
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping

@Configuration
class BatchConfig {

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory
    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory


    // JobBuilderFactory를 통해서 tutorialJob을 생성
    @Bean
    fun batchJob(): Job {
        return jobBuilderFactory["batchJob"]
                .start(batchStep()) // Step 설정
                .build()
    }

    // StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    fun batchStep(): Step {
        return stepBuilderFactory["batchJob"]
                .tasklet(SiteTask()) // Tasklet 설정
                .build()
    }
}