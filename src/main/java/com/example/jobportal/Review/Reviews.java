package com.example.jobportal.Review;

import com.example.jobportal.company.company;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public void setCompany(company company) {
        this.company = company;
    }

    @ManyToOne
   private company company;

    public company getCompany() {
        return company;
    }

    public Reviews(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    private double rating;
}
