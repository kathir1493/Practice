package com.demo.JobManagement;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = org.springframework.boot.test.context.TestConfiguration.class)
@ComponentScan(basePackages = {"com.demo.jobmanagement"})
@SpringBootConfiguration
public class TestConfiguration {
}
