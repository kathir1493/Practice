package com.demo.jobmanagement.jobs;

import com.demo.jobmanagement.service.IJob;
import com.demo.jobmanagement.service.Job;



@Job
public class DataLoaderJob implements IJob  {

    @Override
    public void onError() {

    }

    @Override
    public void run() {
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
