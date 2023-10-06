package com.hexkey.travelmaker.product.hyungmin.dao;

import com.hexkey.travelmaker.product.hyungmin.dto.FileDTO;
import com.hexkey.travelmaker.product.hyungmin.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void insertProduct(ProductDTO product);

    void insertFile(FileDTO file);
}
