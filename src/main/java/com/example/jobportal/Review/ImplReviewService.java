package com.example.jobportal.Review;

import com.example.jobportal.company.company;
import com.example.jobportal.company.companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplReviewService implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private companyservice companyservice;

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> review = reviewRepository.findByCompany_Companyid(companyId);

        return review;
    }

    @Override
    public boolean addreview(Long companyId, Reviews reviews) {
        company Company = companyservice.findByCompanyid(companyId);
        if (Company != null) {
            reviews.setCompany(Company);
            reviewRepository.save(reviews);
            return true;
        }
        return false;
    }

    @Override
    public Reviews getReviews(Long companyId, Long reviewId) {

        List<Reviews> reviews = reviewRepository.findByCompany_Companyid(companyId);
        return reviews.stream().filter(Reviews -> Reviews.getId().equals(reviewId))
                .findFirst().orElse(null);

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedreviews) {
        if(companyservice.findByCompanyid(companyId)!=null){
            updatedreviews.setCompany(companyservice.findByCompanyid(companyId));
            updatedreviews.setId(reviewId);
            reviewRepository.save(updatedreviews);
            return true;

        }
        else {
            return false;
        }
    }

    @Override
    public boolean deletedReview(Long companyId, Long reviewId) {
        if(companyservice.findByCompanyid(companyId)!=null &&
        reviewRepository.existsById(reviewId)){
         Reviews review=   reviewRepository.findById(reviewId).orElse(null);
            assert review != null;
            company Company = review.getCompany();
         Company.getReviews().remove(review);
         review.setCompany(null);
            companyservice.updatecompany(companyId,Company);
            reviewRepository.deleteById(reviewId);

            return true;
        }
        return false;
    }


}
