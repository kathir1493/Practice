package com.demo.jobmanagement.utils;

import java.util.Random;

public class JobIdGenerator {

    private JobIdGenerator(){}

    static Random rand = new Random();

    public static int generateJobId(){
       return rand.nextInt(1000);
    }

}
