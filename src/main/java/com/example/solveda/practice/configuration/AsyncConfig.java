package com.example.solveda.practice.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // core threads
        executor.setMaxPoolSize(5);  // max threads
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("Mongo-");
        executor.initialize();
        return executor;
    }
}
