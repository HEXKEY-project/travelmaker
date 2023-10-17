package com.hexkey.travelmaker.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String getMain() {

        return "/index";

    }

//
//    @GetMapping("/")
//    public String gotoSearch() {
//
//        return null;
//    }


}
