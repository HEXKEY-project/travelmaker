package com.hexkey.travelmaker.search.dao;

import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    int selectTotalCount(Map<String, Object> searchMap);

    List<ProductDTO> selectBySearchCriteria(Map<String, Object> searchMap);

}
