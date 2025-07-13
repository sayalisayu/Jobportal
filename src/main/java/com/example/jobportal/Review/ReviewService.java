package com.example.jobportal.Review;

import java.util.List;

public interface ReviewService {
    List<Reviews> getAllReviews(Long companyId);

    boolean addreview(Long companyId, Reviews reviews);
    Reviews getReviews( Long companyId,Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Reviews reviews);
   boolean deletedReview(Long companyId,Long reviewId);
}
