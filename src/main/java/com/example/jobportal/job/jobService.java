package com.example.jobportal.job;

import java.util.List;

public interface jobService {
    List<jobs> findAll();
    void createjob(jobs job);
}
