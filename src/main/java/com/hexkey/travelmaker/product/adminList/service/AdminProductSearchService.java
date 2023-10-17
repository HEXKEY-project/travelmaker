package com.hexkey.travelmaker.product.adminList.service;

import com.hexkey.travelmaker.product.adminList.dao.AdminProductSearchMapper;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.SelectCondition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductSearchService {

    private final AdminProductSearchMapper adminProductSearchMapper;

    public AdminProductSearchService(AdminProductSearchMapper adminProductSearchMapper) {
        this.adminProductSearchMapper = adminProductSearchMapper;
    }


    public List<SelectCondition> searchProduct(SelectCondition selectCondition) {

        return adminProductSearchMapper.searchProduct(selectCondition);
    }
}
