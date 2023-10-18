package com.hexkey.travelmaker.product.adminList.service;

import com.hexkey.travelmaker.product.adminList.dao.AdminProductSearchMapper;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.SelectCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
@Service
public class AdminProductSearchService {

    private final AdminProductSearchMapper adminProductSearchMapper;

    public AdminProductSearchService(AdminProductSearchMapper adminProductSearchMapper) {
        this.adminProductSearchMapper = adminProductSearchMapper;
    }


    public List<ProductDTO> searchProduct(Map<String, Object> searchCondition) {

        log.info("searchCondition : {}", searchCondition );


        return adminProductSearchMapper.searchProduct(searchCondition);
    }
}

