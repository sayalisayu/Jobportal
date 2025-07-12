package com.example.jobportal.company;

import com.example.jobportal.Review.Reviews;
import com.example.jobportal.job.jobs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyid;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy="Company")
    private List<jobs> job;

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
@JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Reviews> reviews;

    public List<Reviews> getReviews() {
        return reviews;
    }

    public company() {

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



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<jobs> getJob() {
        return job;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }
}
