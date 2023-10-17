package com.hexkey.travelmaker.main.controller;

import com.hexkey.travelmaker.main.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    private MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/main")
    public String getMain(Model model) {

        Map<String, Object> newProductList = mainService.selectNewProductList();

        model.addAttribute("newProductList", newProductList.get("productList"));

        return "/index";

    }

//
//    @GetMapping("/")
//    public String gotoSearch() {
//
//        return null;
//    }


}
