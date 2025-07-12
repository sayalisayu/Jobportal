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
}
