package com.hexkey.travelmaker.product.list.service;

import com.hexkey.travelmaker.product.list.dao.ProductListMapper;
import com.hexkey.travelmaker.product.regist.dto.ProductCategoryDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProductListService {

    private ProductListMapper productListMapper;

    public ProductListService(ProductListMapper productListMapper) {
        this.productListMapper = productListMapper;
    }


    public Map<String, Object> selectSuperCateList(int categoryCode) {

        int totalCount = productListMapper.selectProductTotalCount(categoryCode);
        log.info("product total count : {}", totalCount);

        List<ProductDTO> productList = productListMapper.selectSuperCateList(categoryCode);
        log.info("productList : {}", productList);

        Map<String, Object> supProductList = new HashMap<>();
        supProductList.put("productList", productList);

        return supProductList;
    }

    public ProductCategoryDTO selectCategoryName(int categoryCode) {

        ProductCategoryDTO superCategoryName =  productListMapper.selectCategoryName(categoryCode);

        return superCategoryName;
    }


    public Map<String, Object> selectSubCateList(int categoryCode) {

        int totalCount = productListMapper.selectProductTotalCount(categoryCode);
        log.info("product total count : {}", totalCount);

        List<ProductDTO> productList = productListMapper.selectSubCateList(categoryCode);
        log.info("productList : {}", productList);

        Map<String, Object> subProductList = new HashMap<>();
        subProductList.put("productList", productList);

        return subProductList;
    }


    public Map<String, Object> selectLowestCateList(int categoryCode) {

        int totalCount = productListMapper.selectProductTotalCount(categoryCode);
        log.info("product total count : {}", totalCount);

        List<ProductDTO> productList = productListMapper.selectLowestCateList(categoryCode);
        log.info("productList : {}", productList);

        Map<String, Object> lowProductList = new HashMap<>();
        lowProductList.put("productList", productList);

        return lowProductList;
    }


}
