package com.hexkey.travelmaker.product.list.service;

import com.hexkey.travelmaker.common.migi.paging.Pagenation;
import com.hexkey.travelmaker.common.migi.paging.SelectCriteria;
import com.hexkey.travelmaker.product.list.dao.ProductListMapper;
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


    public Map<String, Object> selectCateList(int page) {

        int totalCount = productListMapper.selectProductTotalCount();
        log.info("product total count : {}", totalCount);

        int limit = 9;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        log.info("product list selectCriteria : {}", selectCriteria);

        List<ProductDTO> productList = productListMapper.selectProductList(selectCriteria);
        log.info("productList : {}", productList);

        Map<String, Object> productListAndPaging = new HashMap<>();
        productListAndPaging.put("paging", selectCriteria);
        productListAndPaging.put("productList", productList);

        return productListAndPaging;
    }
}
