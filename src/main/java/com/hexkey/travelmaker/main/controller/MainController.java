package com.hexkey.travelmaker.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/main", "/"})
    public String getMain() {

        return "/index";

    }

    @PostMapping("/")
    public String redirectMain() {

        return  "redirect:/";

    }

}
