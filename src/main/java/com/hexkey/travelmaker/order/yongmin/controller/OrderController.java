package com.hexkey.travelmaker.order.yongmin.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/order1")
@Controller
public class OrderController {


    @PostMapping("/page1")
    public @ResponseBody ResponseEntity<String> ddd(@RequestBody List<String> ss){
        System.out.println(ss);
        return ResponseEntity.ok("dfsd");
    }
}
