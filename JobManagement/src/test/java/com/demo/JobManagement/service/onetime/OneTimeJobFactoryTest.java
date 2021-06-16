package com.demo.JobManagement.service.onetime;

import com.demo.JobManagement.TestConfiguration;
import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.enums.JobStatus;
import com.demo.jobmanagement.jobs.FileIndexerJob;
import com.demo.jobmanagement.jobs.SampleErrorJob;
import com.demo.jobmanagement.service.JobService;
import com.demo.jobmanagement.service.onetime.OneTimeJobExecutorService;
import com.demo.jobmanagement.service.onetime.OneTimeJobFactory;
import com.demo.jobmanagement.service.scheduled.ScheduledJobExecutorService;
import com.demo.jobmanagement.service.scheduled.ScheduledJobFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= TestConfiguration.class)
class OneTimeJobFactoryTest {


    @Autowired
    OneTimeJobFactory oneTimeJobFactory;

    @Autowired
    JobService jobService;

    @Test
    void executeJob() throws InterruptedException {

        JobDetails jobDetails =  JobDetails.frameJobDetails(new FileIndexerJob(),"low",0l);

        Assertions.assertEquals(JobStatus.QUEUED.name(), jobDetails.getJobStatus());

        oneTimeJobFactory.addJob(jobDetails);
        oneTimeJobFactory.runJob();

        Thread.sleep(5000L); // Waiting for thread to be completed

        Assertions.assertEquals(JobStatus.SUCCESS.name(), jobDetails.getJobStatus());

    }

    @Test
    void executeFailureJob() throws InterruptedException {

        JobDetails jobDetails =  JobDetails.frameJobDetails(new SampleErrorJob(),"low",0l);

        Assertions.assertEquals(JobStatus.QUEUED.name(), jobDetails.getJobStatus());

        oneTimeJobFactory.addJob(jobDetails);
        oneTimeJobFactory.runJob();

        Thread.sleep(5000L); // Waiting for thread to be completed

        Assertions.assertEquals(JobStatus.FAILED.name(), jobDetails.getJobStatus());

    }
}
