package com.hexkey.travelmaker.product.adminList.dao;

import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.SelectCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminProductSearchMapper {

    List<SelectCondition> searchProduct(SelectCondition selectCondition);
}
