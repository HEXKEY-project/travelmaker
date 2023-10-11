package com.hexkey.travelmaker.product.list.dao;

import com.hexkey.travelmaker.common.migi.paging.SelectCriteria;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductListMapper {

    int selectProductTotalCount();

    List<ProductDTO> selectProductList(int categoryCode, SelectCriteria selectCriteria);
}
