package com.hexkey.travelmaker.review.dao;

import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.review.dto.ReviewOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    ReviewOrderDTO selectOrderInfo(int orderCode);

    ProductDTO selectOrderedProduct(int orderCode);

    void insertReview(ReviewDTO review);

    void insertReviewAttachImage(ReviewAttachDTO reviewAttachImage);

}
