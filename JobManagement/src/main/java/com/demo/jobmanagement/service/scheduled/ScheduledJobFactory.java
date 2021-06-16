package com.demo.jobmanagement.service.scheduled;


import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.service.JobFactory;
import com.demo.jobmanagement.utils.JobComparatorOnPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

@Service
@EnableScheduling
public class ScheduledJobFactory implements JobFactory {

    private Queue<JobDetails> jobQueue;

    @Autowired
    private ScheduledJobExecutorService jobExecutorService;


    public ScheduledJobFactory(@Value("${job.factory.queue.size.scheduled:10}") int queueCapacity){
       jobQueue =  new PriorityBlockingQueue<>(queueCapacity,new JobComparatorOnPriority());
    }


    @Override
    public void addJob(JobDetails jobDetails) {
        jobQueue.add(jobDetails);
    }

    @Override
    @Scheduled(fixedRateString = "${job.pollFrequency.scheduled:10000}")
    public void runJob() {
        while (!jobQueue.isEmpty()){
            jobExecutorService.execute(jobQueue.poll());
        }
    }
}
