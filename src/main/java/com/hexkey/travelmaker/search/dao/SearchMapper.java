package com.hexkey.travelmaker.search.dao;

import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<ProductDTO> selectBySearchCriteria(Map<String, String> searchMap);

}
