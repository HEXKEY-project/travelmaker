package com.hexkey.travelmaker.product.list.dao;

import com.hexkey.travelmaker.common.migi.paging.SelectCriteria;
import com.hexkey.travelmaker.product.regist.dto.ProductCategoryDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductListMapper {

    int selectProductTotalCount(int categoryCode);

    List<ProductDTO> selectSuperCateList(int categoryCode, SelectCriteria selectCriteria);

    ProductCategoryDTO selectCategoryName(int categoryCode);

    List<ProductDTO> selectSubCateList(int categoryCode, SelectCriteria selectCriteria);

    List<ProductDTO> selectLowestCateList(int categoryCode, SelectCriteria selectCriteria);
}
