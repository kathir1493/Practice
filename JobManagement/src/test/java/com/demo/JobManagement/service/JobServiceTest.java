package com.demo.JobManagement.service;

import com.demo.JobManagement.TestConfiguration;
import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.entity.JobRequest;
import com.demo.jobmanagement.enums.JobPriority;
import com.demo.jobmanagement.enums.JobStatus;
import com.demo.jobmanagement.jobs.FileIndexerJob;
import com.demo.jobmanagement.service.JobService;

import com.demo.jobmanagement.service.onetime.OneTimeJobFactory;
import com.demo.jobmanagement.service.scheduled.ScheduledJobFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class JobServiceTest {

    @Autowired
    JobService jobService;

    @Test
    public void getAllJobs() {

        Assertions.assertEquals(3, jobService.getAllJobs().size());
        Assertions.assertTrue(jobService.getAllJobs().contains(FileIndexerJob.class.getSimpleName()));

    }

    @Test
    public void executeOneTimeJob() {

        JobRequest jobRequest = new JobRequest();
        jobRequest.setJobType(FileIndexerJob.class.getSimpleName());
        jobRequest.setPriority("HIGH");

        JobDetails jobDetails = jobService.executeOneTimeJob(jobRequest);

        Assertions.assertEquals(JobStatus.QUEUED.name(), jobDetails.getJobStatus());
        Assertions.assertEquals(JobPriority.HIGH, jobDetails.getPriority());
        Assertions.assertTrue( jobDetails.getJobId() > 0 );
        Assertions.assertNull( jobDetails.getScheduledAt());

    }

    @Test
    public void scheduleJob() {

        JobRequest jobRequest = new JobRequest();
        jobRequest.setJobType(FileIndexerJob.class.getSimpleName());
        jobRequest.setPriority("LOW");
        jobRequest.setScheduledAt(1623765545);

        JobDetails jobDetails = jobService.scheduleJob(jobRequest);

        Assertions.assertEquals(JobStatus.QUEUED.name(), jobDetails.getJobStatus());
        Assertions.assertEquals(JobPriority.LOW, jobDetails.getPriority());
        Assertions.assertTrue( jobDetails.getJobId() > 0 );
        Assertions.assertNotNull( jobDetails.getScheduledAt());

    }


}