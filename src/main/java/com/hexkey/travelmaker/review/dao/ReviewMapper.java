package com.hexkey.travelmaker.review.dao;

import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {


    void insertReview(ReviewDTO review);

    void insertReviewAttachImage(ReviewAttachDTO reviewAttachImage);

}
