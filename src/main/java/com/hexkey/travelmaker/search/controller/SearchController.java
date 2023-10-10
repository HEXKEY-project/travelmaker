package com.hexkey.travelmaker.search.controller;

import com.hexkey.travelmaker.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/user/search")
    public String performSearch(@RequestParam("keyword") String keyword, Model model) {

        model.addAttribute("keyword", keyword);

        return "user/search/searchForm";

    }

}
