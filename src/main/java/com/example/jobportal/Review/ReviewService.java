package com.example.jobportal.Review;

import java.util.List;

public interface ReviewService {
    List<Reviews> getAllReviews(Long companyId);

    boolean addreview(Long companyId, Reviews reviews);
}
