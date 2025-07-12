package com.example.jobportal.Review;

import com.example.jobportal.company.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Companies")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{companyId}")
    private ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId) {

        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }

    @PostMapping("{companyId}/reviews")
    private ResponseEntity<String> CreateReviews(@PathVariable Long companyId, @RequestBody Reviews reviews) {
        boolean isReviewsaved = reviewService.addreview(companyId, reviews);
        if (isReviewsaved) {
            return new ResponseEntity<>("Review Added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review is not  added", HttpStatus.NOT_FOUND);
        }

    }
}
