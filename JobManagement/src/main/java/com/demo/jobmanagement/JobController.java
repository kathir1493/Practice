package com.demo.jobmanagement;


import com.demo.jobmanagement.entity.JobDetails;
import com.demo.jobmanagement.entity.JobRequest;
import com.demo.jobmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(path = "/jobs",produces = "application/json; charset=UTF-8")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public Set<String> getJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/status")
    public Collection<JobDetails> getJobStatus(){
        return jobService.getAllJobStatus();
    }

    @GetMapping("/status/{id}")
    public JobDetails getJobDetailsByJobName(@PathVariable("id") int id){
        return jobService.getJobStatusById(id);
    }

    @PostMapping("/execute/")
    public JobDetails executeByJobName(@RequestBody JobRequest jobRequest){
        return jobService.executeOneTimeJob(jobRequest);
    }

    @PostMapping("/schedule/")
    public JobDetails scheduleByJobName(@RequestBody JobRequest jobRequest){
        return jobService.scheduleJob(jobRequest);
    }
}
