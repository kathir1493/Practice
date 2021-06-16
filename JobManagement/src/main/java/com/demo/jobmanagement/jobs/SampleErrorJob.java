package com.demo.jobmanagement.jobs;

import com.demo.jobmanagement.service.IJob;
import com.demo.jobmanagement.service.Job;
import lombok.extern.slf4j.Slf4j;

@Job
@Slf4j
public class SampleErrorJob implements IJob {

    @Override
    public void onError() {
        log.info("Rolling back");
    }

    @Override
    public void run(){
        throw new RuntimeException();
    }
}