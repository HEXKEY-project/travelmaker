package com.hexkey.travelmaker.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderPageController {

    @GetMapping("/order/page")
    public void orderPage () {}

    @GetMapping("/map/map")
    public void map () {}

    @GetMapping("/order/pay")
    public void pay () {}


}
