package com.hexkey.travelmaker.order.orderpage.controller;

import com.hexkey.travelmaker.order.orderpage.service.AdminOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@Controller
public class AdminOrderController {


    private final AdminOrderService adminOrderService;

    @Autowired
    public AdminOrderController (AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @GetMapping("/admin/order")
    public String adminOrder(Model model) {

        Map<String, Object> selectAdminOrderMap = adminOrderService.selectAdminOrder("0", "0", "", "");

        model.addAttribute("orderDTOs", selectAdminOrderMap.get("orderDTO"));

        return "admin/order/adminOrder";
    }


    @PostMapping("/admin/order")
    public String adminOrder(@RequestParam(required = false) String searchCondition,
                             @RequestParam(required = false) String searchValue,
                             @RequestParam(required = false) String orderDate1,
                             @RequestParam(required = false) String orderDate2,
                             Model model) {

        log.info("{}", orderDate1);
        log.info("{}", orderDate2);

        Map<String, Object> selectAdminOrderMap = adminOrderService.selectAdminOrder(searchCondition, searchValue, orderDate1, orderDate2);

        model.addAttribute("AdminOrderSelectDTOList", selectAdminOrderMap.get("AdminOrderSelectDTOList"));

        return "admin/order/adminOrder";
    }
}
