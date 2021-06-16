package com.demo.jobmanagement.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class JobFactoryConfig {

    @Bean
    @Qualifier("jobExecutorPool")
    public ExecutorService jobExecutorPool(@Value("${job.thread.poolsize.onetime:20}") int  nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Bean
    @Qualifier("scheduledJobExecutorPool")
    public ScheduledExecutorService scheduledJobExecutorPool(@Value("${job.thread.poolsize.scheduled:20}") int  nThreads) {
        return new ScheduledThreadPoolExecutor(nThreads);
    }
}
