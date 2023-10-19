package com.hexkey.travelmaker.product.adminList.controller;

import com.hexkey.travelmaker.product.adminList.service.AdminProductSearchService;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.SelectCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/product")
public class AdminProductSearchController {

    private final AdminProductSearchService adminProductSearchService;

    public AdminProductSearchController(AdminProductSearchService adminProductSearchService) {
        this.adminProductSearchService = adminProductSearchService;
    }



    @GetMapping("/list")
    public String getProductList(@RequestParam(required = false) Map<String, Object> searchCondition,
                                 Model model) {

        log.info("------searchCondition : {}", searchCondition);
        List<ProductDTO> selectConditionList = adminProductSearchService.searchProduct(searchCondition);
        log.info("------selectConditionList : {}", selectConditionList);

        model.addAttribute("productList", selectConditionList);

        return "/admin/product/list";
    }

}
