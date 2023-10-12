package com.hexkey.travelmaker.product.detail.service;

import com.hexkey.travelmaker.product.detail.dao.ProductDetailMapper;
import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class ProductDetailService {

    private final ProductDetailMapper productDetailMapper;

    public ProductDetailService(ProductDetailMapper productDetailMapper) {
        this.productDetailMapper = productDetailMapper;
    }

    public ProductDTO selectProductDetail(Long productSeq) {
        ProductDTO productDetail = productDetailMapper.selectProductDetail(productSeq);
        List<ProductOptionDTO> optionList  = productDetailMapper.selectProductOption(productSeq);
        List<FileDTO> fileList = productDetailMapper.selectProductFile(productSeq);

        log.info("productDetail : {}", productDetail);
        log.info("optionList : {}", optionList);
        log.info("fileList : {}", fileList);

        productDetail.setProductOption(optionList);
        productDetail.setFileList(fileList);

        log.info("productDetail : {}", productDetail);

        return productDetail;
    }


}
