package com.hexkey.travelmaker.admin.product.service;

import com.hexkey.travelmaker.admin.product.dao.ProductMapper;
import com.hexkey.travelmaker.admin.product.dto.FileDTO;
import com.hexkey.travelmaker.admin.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) { this.productMapper = productMapper;}

    public void registProduct(ProductDTO product) {

        /* Product 테이블에 데이터 저장 */
        productMapper.insertProductContent(product);

        /* File 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        for(FileDTO file : product.getFileList()) {
            productMapper.insertFile(file);
        }
    }
}
