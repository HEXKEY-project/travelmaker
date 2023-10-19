package com.hexkey.travelmaker.main.dao;

import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {


    List<ProductDTO> selectNewProductList();

    List<ReviewDTO> selectRecentReviewList();

//    List<ProductDTO> selectOrderedProductList();

}
