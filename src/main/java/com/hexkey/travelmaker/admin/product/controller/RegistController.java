package com.hexkey.travelmaker.admin.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class RegistController {

    @GetMapping("/regist")
    public void registPage(){}
}
