package com.hexkey.travelmaker.search.controller;

import com.hexkey.travelmaker.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/user/search")
    public String performSearch(@RequestParam("searchValue") String searchValue, @RequestParam(required = false) String searchCondition, Model model) {



        model.addAttribute("searchValue", searchValue);

        return "/user/search/searchForm";
    }

    @GetMapping("/user/searchForm")
    public String selectBySearchCriteria(@RequestParam("categoryCode") int categoryCode, @RequestParam("searchCondition") String searchCondition, @RequestParam("searchValue") String searchValue, @RequestParam(required = false) int productPrice1,
                                         @RequestParam(required = false) int productPrice2, Model model) {

        log.info("categoryCode : {}", categoryCode);
        log.info("searchCondition : {}", searchCondition);
        log.info("searchValue : {}", searchValue);
        log.info("productPrice1 : {}", productPrice1);
        log.info("productPrice2 : {}", productPrice2);

        Map<String, Object> searchMap = new HashMap<>();

        searchMap.put("categoryCode", categoryCode);
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("productPrice1", productPrice1);
        searchMap.put("productPrice2", productPrice2);

        Map<String, Object> searchResultMap = searchService.selectBySearchCriteria(searchMap);
        model.addAttribute("totalCount", searchResultMap.get("totalCount"));
        model.addAttribute("searchResultList", searchResultMap.get("searchResultList"));

        return "user/search/searchForm";
    }

}
