package com.venkatesh.firstjobapp.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);
}
