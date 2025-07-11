package com.example.jobportal.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ImpljobService implements jobService {
    private List<jobs> jobs= new ArrayList<>();
    private Long Nextid=1L;
    @Override
    public List<jobs> findAll() {
        return jobs;
    }

    @Override
    public void createjob(jobs job) {
        job.setId(Nextid++);
     jobs.add(job);
    }
}
