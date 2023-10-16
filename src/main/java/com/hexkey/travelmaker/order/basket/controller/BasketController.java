package com.hexkey.travelmaker.order.basket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

    @GetMapping("/basket/basket")
    public String basket () {
        return "user/order/basket";
    }

}
