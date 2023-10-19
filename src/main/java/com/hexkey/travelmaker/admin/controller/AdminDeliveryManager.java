package com.hexkey.travelmaker.admin.controller;


import com.hexkey.travelmaker.admin.service.DeliveryManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminDeliveryManager {

    private final DeliveryManagerService deliveryManagerService;

    public AdminDeliveryManager(DeliveryManagerService deliveryManagerService) {
        this.deliveryManagerService = deliveryManagerService;
    }


    @GetMapping("/deliveryManager")
    public String getDeliveryManager(){


        return "admin/user/adminDeliveryManager";
    }

}
