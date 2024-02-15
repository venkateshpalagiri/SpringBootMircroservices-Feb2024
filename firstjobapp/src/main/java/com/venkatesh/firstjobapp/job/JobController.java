package com.venkatesh.firstjobapp.job;

import com.venkatesh.firstjobapp.job.impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
    private List<Job> jobs=new ArrayList<>();
//    private JobService jobService=new JobServiceImpl();
    private JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
//        return ResponseEntity.ok(jobService.findAll());
        return ResponseEntity.ok(jobService.findAll());

    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job=jobService.getJobById(id);
        if (job!=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
