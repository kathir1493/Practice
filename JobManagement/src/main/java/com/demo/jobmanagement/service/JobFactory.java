package com.demo.jobmanagement.service;

import com.demo.jobmanagement.entity.JobDetails;

public interface JobFactory {

    void addJob(JobDetails jobDetails);

    void runJob();

}
