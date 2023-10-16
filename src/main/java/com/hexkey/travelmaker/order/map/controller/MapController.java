package com.hexkey.travelmaker.order.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/map/map")
    public String map() {
        return "user/map/map";
    }

}



