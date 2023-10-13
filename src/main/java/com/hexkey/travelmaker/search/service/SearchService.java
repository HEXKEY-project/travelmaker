package com.hexkey.travelmaker.search.service;

import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import com.hexkey.travelmaker.search.dao.SearchMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    private SearchMapper searchMapper;

    public SearchService(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }

    public Map<String, Object> selectBySearchCriteria(Map<String, String> searchMap) {

        /* 검색 결과 조회 - 검색된 상품의 수 */
        int totalCount = searchMapper.selectTotalCount(searchMap);
        /* 검색 결과 조회 - 검색된 상품 리스트 */
        List<ProductDTO> searchResultList = searchMapper.selectBySearchCriteria(searchMap);

        Map<String, Object> searchResultMap = new HashMap<>();
        searchResultMap.put("totalCount", totalCount);
        searchResultMap.put("searchResultList", searchResultList);

        return searchResultMap;
    }


}
