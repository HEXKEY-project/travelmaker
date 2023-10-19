package com.hexkey.travelmaker.main.service;

import com.hexkey.travelmaker.main.dao.MainMapper;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.review.dto.ReviewOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MainService {

    private MainMapper mainMapper;

    public MainService(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public Map<String, Object> selectNewProductList() {

        List<ProductDTO> productList = mainMapper.selectNewProductList();

        log.info("productList : {}", productList);

        Map<String, Object> newProductList = new HashMap<>();

        newProductList.put("productList", productList);

        return newProductList;
    }

    public Map<String, Object> selectRecentReviewList() {

        List<ReviewDTO> reviewList = mainMapper.selectRecentReviewList();

        log.info("reviewList : {}", reviewList);

        Map<String, Object> recentReviewList = new HashMap<>();

        recentReviewList.put("reviewList", reviewList);

        return recentReviewList;
    }


}
