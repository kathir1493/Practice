package com.demo.jobmanagement.service;

import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.entity.JobRequest;
import com.demo.jobmanagement.service.onetime.OneTimeJobFactory;
import com.demo.jobmanagement.service.scheduled.ScheduledJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {

    @Autowired
    ScheduledJobFactory scheduledJobFactory;

    @Autowired
    OneTimeJobFactory oneTimeJobFactory;


    private Map<String, IJob> jobDetailsMap = new HashMap<>();
    private Map<Integer, JobDetails> jobStatusMap = new HashMap<>();


    public void addJobDetails(IJob iJob){
        jobDetailsMap.put(iJob.getClass().getSimpleName(),iJob);
    }

    public JobDetails getJobStatusById(int jobId){
        return jobStatusMap.get(jobId);
    }

    public Collection<JobDetails> getAllJobStatus(){
        return jobStatusMap.values();
    }

    public Set<String> getAllJobs(){
        return jobDetailsMap.keySet();
    }


    public JobDetails executeOneTimeJob(JobRequest jobRequest){
       return executeJobByName(jobRequest.getJobType(),jobRequest.getPriority(),0);
    }

    public JobDetails scheduleJob(JobRequest jobRequest){
        return executeJobByName(jobRequest.getJobType(),jobRequest.getPriority(),jobRequest.getScheduledAt());
    }

    private JobDetails executeJobByName(String jobType,String priority,long scheduledAt) {

        if(jobDetailsMap.containsKey(jobType)) {
            IJob job = jobDetailsMap.get(jobType);
            JobDetails jobDetails = JobDetails.frameJobDetails(job,priority,scheduledAt);
            jobStatusMap.put(jobDetails.getJobId(),jobDetails);
            if(scheduledAt == 0) {
                oneTimeJobFactory.addJob(jobDetails);
            }else {
                scheduledJobFactory.addJob(jobDetails);
            }
            return jobDetails;
        }else {
            return null; // Exception Can be thrown as per requirement
        }

    }

    }
