package com.example.jobportal.company;

import com.example.jobportal.job.jobs;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<jobs> job;
    public company() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJob(List<jobs> job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<jobs> getJob() {
        return job;
    }
}
