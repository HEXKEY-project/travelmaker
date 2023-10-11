package com.hexkey.travelmaker.product.detail.dao;

import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDetailMapper {
    ProductDTO selectProductDetail(Long productSeq);
}
