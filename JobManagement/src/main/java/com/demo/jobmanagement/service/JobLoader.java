package com.demo.jobmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JobLoader {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    JobService jobService;

    @PostConstruct
    public void init()  {
        applicationContext.getBeansWithAnnotation(Job.class).values().parallelStream().filter(beans -> beans instanceof IJob).
                map( k -> (IJob)k).forEach(jobService::addJobDetails);
    }

}
