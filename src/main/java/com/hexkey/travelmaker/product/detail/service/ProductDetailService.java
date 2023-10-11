package com.hexkey.travelmaker.product.detail.service;

import com.hexkey.travelmaker.product.detail.dao.ProductDetailMapper;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductDetailService {

    private final ProductDetailMapper productDetailMapper;

    public ProductDetailService(ProductDetailMapper productDetailMapper) {
        this.productDetailMapper = productDetailMapper;
    }

    public ProductDTO selectProductDetail(Long productSeq) {

        return productDetailMapper.selectProductDetail(productSeq);
    }
}
