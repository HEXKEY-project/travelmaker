package com.hexkey.travelmaker.review.service;

import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.review.dao.ReviewMapper;
import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.review.dto.ReviewOrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    private ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public ProductDTO selectOrderedProduct(int orderCode) {

        ProductDTO orderedProduct = reviewMapper.selectOrderedProduct(orderCode);

        return orderedProduct;
    }

    public ReviewOrderDTO selectOrderInfo(int orderCode) {

        ReviewOrderDTO orderInfo = reviewMapper.selectOrderInfo(orderCode);

        return orderInfo;
    }

    public void registerReview(ReviewDTO review) {

        reviewMapper.insertReview(review);

        for (ReviewAttachDTO reviewAttachImage : review.getReviewAttachList()) {
            reviewMapper.insertReviewAttachImage(reviewAttachImage);
        }

    }

}
