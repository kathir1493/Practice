package com.demo.JobManagement.service.scheduled;

import com.demo.JobManagement.TestConfiguration;
import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.entity.JobRequest;
import com.demo.jobmanagement.enums.JobPriority;
import com.demo.jobmanagement.enums.JobStatus;
import com.demo.jobmanagement.jobs.FileIndexerJob;
import com.demo.jobmanagement.service.JobService;
import com.demo.jobmanagement.service.onetime.OneTimeJobFactory;
import com.demo.jobmanagement.service.scheduled.ScheduledJobExecutorService;
import com.demo.jobmanagement.service.scheduled.ScheduledJobFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= TestConfiguration.class)
class ScheduledJobFactoryTest {


    @Autowired
    ScheduledJobFactory scheduledJobFactory;


    @Autowired
    JobService jobService;

    @Test
    void scheduleJob() throws InterruptedException {


        JobDetails jobDetails =  JobDetails.frameJobDetails(new FileIndexerJob(),"low",0l);
        jobDetails.setScheduledAt(Instant.now().plus(5L,ChronoUnit.SECONDS));

        Assertions.assertEquals(JobStatus.QUEUED.name(), jobDetails.getJobStatus());

        scheduledJobFactory.addJob(jobDetails);
        scheduledJobFactory.runJob();

        Thread.sleep(5000L); // Waiting for thread to be completed


        Assertions.assertEquals(JobStatus.SUCCESS.name(), jobDetails.getJobStatus());

    }
}