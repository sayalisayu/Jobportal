package com.example.jobportal.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class jobcontroller {
    @Autowired
    private jobService service;
    public jobcontroller(jobService service){
        this.service=service;
    }
    private List<jobs>jobs=new ArrayList<>();
    @GetMapping("/jobs")
    public List<jobs> findAll()
    {
        return service.findAll();
    }
    @PostMapping("/Save")
    public String Createjob(@RequestBody jobs Jobs)
    {
        service.createjob(Jobs);
        return "Value save successfully " ;
    }



    //GET /jobs/{id}:Get a specific job by ID
    //POST /jobs:Create a new job(request body should contain the job details)
    //DELETE /jobs/{id}:Delete a specific job by ID
    //PUT /jobs/{id}: Update a specific job by ID(request body should contain the updated job
    //GET /jobs/{id}/company: Get the company associated with a specific job by ID
    //Example API URLs:
    //GET {base_url}/jobs
    //GET {base_url}/jobs/1
    //POST {base_url}/jobs
    //DELETE {base_url}/jobs/1
    //PUT {base_url}/jobs/1
    //
}
