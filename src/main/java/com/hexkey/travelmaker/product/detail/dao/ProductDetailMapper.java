package com.hexkey.travelmaker.product.detail.dao;

import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDetailMapper {
    ProductDTO selectProductDetail(Long productSeq);


    List<ProductOptionDTO> selectProductOption(Long productSeq);

    List<FileDTO> selectProductFile(Long productSeq);
}
