package com.hexkey.travelmaker.product.adminList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class AdminProductListController {

    @GetMapping("/list")
    public void getProductList(){

    }
}
