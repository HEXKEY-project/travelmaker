package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductOptionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductOrderMapper {


    ProductOptionDTO selectProductOption(int optionCode);

    ProductDTO selectProduct(int productSeq);
}
