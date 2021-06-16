package com.demo.jobmanagement.jobs;

import com.demo.jobmanagement.service.IJob;
import com.demo.jobmanagement.service.Job;
import lombok.extern.slf4j.Slf4j;

@Job
@Slf4j
public class FileIndexerJob implements IJob {

    @Override
    public void onError() {

    }

    @Override
    public void run() {

        log.info("Rolling back");

    }
}