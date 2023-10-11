package com.hexkey.travelmaker.product.detail.service;

import com.hexkey.travelmaker.product.detail.dao.ProductDetailMapper;
import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public List<ProductOptionDTO> selectProductOption(Long productSeq) {
        return productDetailMapper.selectProductOption(productSeq);
    }

    public List<FileDTO> selectProductFile(Long productSeq) {
        return productDetailMapper.selectProductFile(productSeq);
    }
}
