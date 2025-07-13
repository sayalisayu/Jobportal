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

    @GetMapping("{companyId}/reviews/{reviewId}")
    private ResponseEntity<Reviews> getReviews(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId, reviewId), HttpStatus.OK);

    }

    @PutMapping("{companyId}/reviews/{reviewId}")
    private ResponseEntity<String> UpdateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Reviews reviews) {
        boolean isReviewsupdated = reviewService.updateReview(companyId, reviewId, reviews);
        if (isReviewsupdated) {
            return new ResponseEntity<>("Review Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review is  not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{companyId}/reviews/{reviewId}")
    private ResponseEntity<String> DeleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deletedReview(companyId, reviewId);
        if (isDeleted) {
            return new ResponseEntity<>("Review is Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review is  not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}
