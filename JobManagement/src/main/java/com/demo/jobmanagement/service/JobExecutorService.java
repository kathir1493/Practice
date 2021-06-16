package com.demo.jobmanagement.service;

import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.enums.JobStatus;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JobExecutorService implements Runnable {


    private static final String JOB_TYPE = "Job Type";

    private static final String JOB_ID = "ID";

    private JobDetails jobDetails;


    public  JobExecutorService (JobDetails jobDetails) {
        this.jobDetails = jobDetails;
    }

    @Override
    public void run() {
        IJob job = jobDetails.getJob();
        int jobId = jobDetails.getJobId();

        try {
            jobDetails.setJobStatus(JobStatus.RUNNING.name());
            log.info(JOB_TYPE +jobDetails.getJobType()+" "+JOB_ID+" "+ jobId +" "+ JobStatus.RUNNING.name());
            job.run();
            jobDetails.setJobStatus(JobStatus.SUCCESS.name());
            log.info(JOB_TYPE +jobDetails.getJobType()+" "+JOB_ID+" "+ jobId +" "+ JobStatus.SUCCESS.name());
        }catch (Exception e){
            log.info(JOB_TYPE +jobDetails.getJobType()+" "+JOB_ID+" "+ jobId +" "+ JobStatus.FAILED.name());
            job.onError();
            jobDetails.setJobStatus(JobStatus.FAILED.name());
            log.info(JOB_TYPE +jobDetails.getJobType()+" "+JOB_ID+" "+ "  : RolledBack");

        }
    }

}
