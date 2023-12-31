package com.hexkey.travelmaker.main.controller;

import com.hexkey.travelmaker.main.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Slf4j
@Controller
public class MainController {

    private MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String getMain(Model model) {

        Map<String, Object> newProductList = mainService.selectNewProductList();
        Map<String, Object> reviewList = mainService.selectRecentReviewList();


        model.addAttribute("newProductList", newProductList.get("productList"));
        model.addAttribute("recentReviewList", reviewList.get("reviewList"));

        log.info("recentReviewList : {}", reviewList);

        return "/index";

    }


}
