package com.hexkey.travelmaker.review.service;

import com.hexkey.travelmaker.review.dao.ReviewMapper;
import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    private ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public void registerReview(ReviewDTO review) {

        reviewMapper.insertReview(review);

        for (ReviewAttachDTO reviewAttachImage : review.getReviewAttachList()) {
            reviewMapper.insertReviewAttachImage(reviewAttachImage);
        }

    }
}
