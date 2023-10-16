package com.hexkey.travelmaker.product.list.controller;

import com.hexkey.travelmaker.product.list.service.ProductListService;
import com.hexkey.travelmaker.product.regist.dto.ProductCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/user/product/list")
@Slf4j
@Controller
public class ProductListController {

    private ProductListService productListService;

    public ProductListController(ProductListService productListService) {
        this.productListService = productListService;
    }

    @GetMapping("/supList")
    public String selectSuperCateList(@RequestParam("categoryCode") int categoryCode, Model model) {

        Map<String, Object> supCateProductListAndPaging = productListService.selectSuperCateList(categoryCode);

        ProductCategoryDTO categoryName = productListService.selectCategoryName(categoryCode);

        model.addAttribute("paging", supCateProductListAndPaging.get("paging"));
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("productList", supCateProductListAndPaging.get("productList"));
        model.addAttribute("superCategoryName", categoryName);

        return "/user/product/list/supList";
    }

    @GetMapping("/subList")
    public String selectSubCategoryList(@RequestParam("categoryCode") int categoryCode, @RequestParam(defaultValue = "1") int page, Model model) {

        Map<String, Object> productListAndPaging = productListService.selectSubCateList(categoryCode, page);
        ProductCategoryDTO subCategoryName = productListService.selectCategoryName(categoryCode);

        model.addAttribute("paging", productListAndPaging.get("paging"));
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("productList", productListAndPaging.get("productList"));
        model.addAttribute("subCategoryName", subCategoryName);

        return "/user/product/list/subList";
    }

    @GetMapping("/lowestList")
    public String selectLowestCategoryList(@RequestParam("categoryCode") int categoryCode, @RequestParam(defaultValue = "1") int page, Model model) {

        Map<String, Object> productListAndPaging = productListService.selectLowestCateList(categoryCode, page);
        ProductCategoryDTO lowestCategoryName = productListService.selectCategoryName(categoryCode);

        model.addAttribute("paging", productListAndPaging.get("paging"));
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("productList", productListAndPaging.get("productList"));
        model.addAttribute("lowestCategoryName", lowestCategoryName);

        return "/user/product/list/lowestList";

    }

}
