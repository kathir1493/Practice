package com.demo.jobmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobRequest implements Serializable {


    @JsonProperty
    String jobType;

    @JsonProperty
    String priority;

    @JsonProperty
    long scheduledAt;

}
