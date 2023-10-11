package com.hexkey.travelmaker.product.list.controller;

import com.hexkey.travelmaker.product.list.service.ProductListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/user/product")
@Slf4j
@Controller
public class ProductListController {

    private ProductListService productListService;

    public ProductListController(ProductListService productListService) {
        this.productListService = productListService;
    }

    @GetMapping("/list")
    public String selectCateList(@RequestParam("categoryCode") int categoryCode, @RequestParam(defaultValue = "1") int page, Model model) {

        Map<String, Object> productListAndPaging = productListService.selectCateList(categoryCode, page);

        model.addAttribute("paging", productListAndPaging.get("paging"));
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("productList", productListAndPaging.get("productList"));

        return "/user/product/list";
    }

}
