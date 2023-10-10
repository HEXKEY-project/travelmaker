package com.hexkey.travelmaker.product.regist.dao;

import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRegistMapper {
    void insertProduct(ProductDTO product);

    void insertFile(FileDTO file);

    void insertProductSuperOpt(ProductOptionDTO productOptionDTO);

    void insertProductSubOpt(ProductOptionDTO productOptionDTO);
}
