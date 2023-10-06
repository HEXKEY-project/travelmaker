package com.hexkey.travelmaker.product.regist.service;

import com.hexkey.travelmaker.product.regist.dao.ProductMapper;
import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) { this.productMapper = productMapper;}

    public void registProduct(ProductDTO product) {

        /* Product 테이블에 데이터 저장 */
        productMapper.insertProduct(product);
        List<ProductOptionDTO> productOption = product.getProductOption();
        for(int i = 0; i < productOption.size(); i++) {
            if(i == 0) {
                //productMapper.insertProductSuperOption(productOption.get(i));
            } else {
                //productMapper.insertProductSubOption(productOption.get(i));
            }
        }


        /* File 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        for(FileDTO file : product.getFileList()) {
            productMapper.insertFile(file);
        }
    }
}
