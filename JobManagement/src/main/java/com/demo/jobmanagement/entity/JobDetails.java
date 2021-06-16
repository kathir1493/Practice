package com.demo.jobmanagement.entity;

import com.demo.jobmanagement.enums.JobPriority;
import com.demo.jobmanagement.enums.JobStatus;
import com.demo.jobmanagement.service.IJob;
import com.demo.jobmanagement.utils.JobIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;


@Data
@JsonIgnoreProperties(value = { "job" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDetails implements Serializable {

    private int jobId;

    private String jobType;

    private Instant scheduledAt;

    private JobPriority priority;

    private String jobStatus;

    private IJob job;

    private JobDetails(){}

   public static JobDetails frameJobDetails(IJob iJob,String priority,long scheduledAt){

       JobDetails jobDetails = new JobDetails();

       jobDetails.setJobId(JobIdGenerator.generateJobId());
       jobDetails.setJobType(iJob.getClass().getSimpleName());
       jobDetails.setJobStatus(JobStatus.QUEUED.name());

       try {
           if (priority != null) {
               jobDetails.setPriority(JobPriority.valueOf(priority.toUpperCase()));
           } else {
               jobDetails.setPriority(JobPriority.LOW);
           }
       }catch (IllegalArgumentException ex){
           jobDetails.setPriority(JobPriority.LOW);
           // Default behaviour can be defined here
       }

       if(scheduledAt!=0){
           jobDetails.setScheduledAt(Instant.ofEpochSecond(scheduledAt));
       }

       jobDetails.setJob(iJob);

        return jobDetails;
    }


}
