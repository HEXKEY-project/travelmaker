package com.hexkey.travelmaker.order.yongmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order3")
public class OrderPageController3 {

    @PostMapping("/page3")
    public String dd (String selectedOptionsData){
        System.out.println(selectedOptionsData);

        return "/admin/product/regist";
    }

}
