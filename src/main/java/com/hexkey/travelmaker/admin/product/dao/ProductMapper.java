package com.hexkey.travelmaker.admin.product.dao;

import com.hexkey.travelmaker.admin.product.dto.FileDTO;
import com.hexkey.travelmaker.admin.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void insertProductContent(ProductDTO product);

    void insertFile(FileDTO file);
}
