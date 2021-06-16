package com.demo.jobmanagement.utils;

import com.demo.jobmanagement.entity.JobDetails;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class JobComparatorOnScheduledTime  implements Comparator<JobDetails> {
    @Override
    public int compare(JobDetails o1, JobDetails o2) {

        if(o1.getScheduledAt().compareTo(o2.getScheduledAt()) == 0){
            return o2.getPriority().compareTo(o1.getPriority());
        }

        return o1.getScheduledAt().compareTo(o2.getScheduledAt());
    }
}
