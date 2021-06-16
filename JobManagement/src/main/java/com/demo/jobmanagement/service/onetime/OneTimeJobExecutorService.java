package com.demo.jobmanagement.service.onetime;

import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.service.JobExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class OneTimeJobExecutorService {

    @Autowired
    @Qualifier("jobExecutorPool")
    private ExecutorService executorService;

    public void execute(JobDetails jobDetails){
        executorService.execute(new JobExecutorService(jobDetails));
    }


}
