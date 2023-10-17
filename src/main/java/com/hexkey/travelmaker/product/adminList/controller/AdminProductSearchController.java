package com.hexkey.travelmaker.product.adminList.controller;

import com.hexkey.travelmaker.product.adminList.service.AdminProductSearchService;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.SelectCondition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/product")
public class AdminProductSearchController {

    private final AdminProductSearchService adminProductSearchService;

    public AdminProductSearchController(AdminProductSearchService adminProductSearchService) {
        this.adminProductSearchService = adminProductSearchService;
    }

    @GetMapping("/list")
    public String getProductList(@RequestParam SelectCondition selectCondition,
                                 Model model) {

        List<SelectCondition> selectConditionList = adminProductSearchService.searchProduct(selectCondition);


        /*ProductDTO productList = adminProductSearchService.searchProduct();*/


        return "/admin/product/list";
    }
}
