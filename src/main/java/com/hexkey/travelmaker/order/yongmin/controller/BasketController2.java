package com.hexkey.travelmaker.order.yongmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BasketController2 {

    @GetMapping("/basket1/basket1/")
    public String dd(@RequestBody List<String> data){

        System.out.println(data);
        return "admin/product/regist";
    }
}
