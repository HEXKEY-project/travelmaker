package com.hexkey.travelmaker.product.regist.service;

import com.hexkey.travelmaker.product.regist.dao.ProductRegistMapper;
import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductRegistService {

    private final ProductRegistMapper productRegistMapper;

    public ProductRegistService(ProductRegistMapper productRegistMapper) { this.productRegistMapper = productRegistMapper;}

    public void registProduct(ProductDTO product) {

        /* Product 테이블에 데이터 저장 */
        productRegistMapper.insertProduct(product);

        List<ProductOptionDTO> productOption = product.getProductOption();
        for(int i = 0; i < productOption.size(); i++) {
            if(i == 0) {
                /* 첫번째 옵션값에는 refOptionCode는 null값 */
                productRegistMapper.insertProductSuperOpt(productOption.get(i));
            } else {
                /* 두번째 옵션값에 처음 옵션코드를 refOptionCode로 고정시키 위해 */
                productOption.get(i).setRefOptionCode(productOption.get(0).getRefOptionCode());
                productRegistMapper.insertProductSubOpt(productOption.get(i));
            }
        }


        /* File 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        for(FileDTO file : product.getFileList()) {
            productRegistMapper.insertFile(file);
        }
    }
}
