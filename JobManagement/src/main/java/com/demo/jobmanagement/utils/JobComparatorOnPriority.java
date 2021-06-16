package com.demo.jobmanagement.utils;

import com.demo.jobmanagement.entity.JobDetails;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class JobComparatorOnPriority implements Comparator<JobDetails> {
    @Override
    public int compare(JobDetails o1, JobDetails o2) {
        return o2.getPriority().compareTo(o1.getPriority());
    }
}
