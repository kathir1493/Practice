package com.demo.jobmanagement.service.scheduled;

import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.enums.JobStatus;
import com.demo.jobmanagement.service.JobExecutorService;
import com.demo.jobmanagement.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ScheduledJobExecutorService {

    @Autowired
    @Qualifier("scheduledJobExecutorPool")
    private ScheduledExecutorService executorService;

    void execute(JobDetails jobDetails){

        long timeDifference =  Duration.between(Instant.now(),jobDetails.getScheduledAt()).getSeconds();

        if(timeDifference >= 0) {
            log.info("Job " + jobDetails.getJobId() + " : Scheduled At " + jobDetails.getScheduledAt());
            executorService.schedule(new JobExecutorService(jobDetails), timeDifference, TimeUnit.SECONDS);
        }else {
            log.info("Job " + jobDetails.getJobId() + " : Not Scheduled : Scheduled time should be a Future time [ " + jobDetails.getScheduledAt() + " ]");
            jobDetails.setJobStatus(JobStatus.FAILED.name());

        }
    }



}

