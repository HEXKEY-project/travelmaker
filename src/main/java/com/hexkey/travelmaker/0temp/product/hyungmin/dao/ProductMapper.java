package com.hexkey.travelmaker;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void insertProduct(ProductDTO product);

    void insertFile(FileDTO file);
}
