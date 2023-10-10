package com.hexkey.travelmaker.product.detail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/product")
public class ProductDetailController {

    @GetMapping("/detail")
    public String selectProductDetail(){


        return "/user/product/detail";
    }
}
