package com.hexkey.travelmaker.community.zeesang;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/templates")
public class Controller {
    @GetMapping("/index")
    public String index(){
        return "/index";
    }
}
