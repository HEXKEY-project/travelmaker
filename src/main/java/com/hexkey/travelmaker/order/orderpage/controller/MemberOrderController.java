package com.hexkey.travelmaker.order.orderpage.controller;

import com.hexkey.travelmaker.order.orderpage.dto.AdminOrderSelectDTO;
import com.hexkey.travelmaker.order.orderpage.service.AdminOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class MemberOrderController {

    private final AdminOrderService adminOrderService;

    @Autowired
    public MemberOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @GetMapping("/order/member")
    public String orderMember(Model model) {


        return "user/order/memberOrder";
    }

    @PostMapping("/order/member")
    @ResponseBody
    public List<AdminOrderSelectDTO> selectOrderMember(@RequestParam(required = false) String searchCondition,
                                                       @RequestParam(required = false) String searchValue,
                                                       @RequestParam(required = false) String orderDate1,
                                                       @RequestParam(required = false) String orderDate2) {

        Map<String, Object> selectAdminOrderMap = adminOrderService.selectMemberOrder(searchCondition, searchValue, orderDate1, orderDate2);

        log.info("selectAdminOrderMap : {}", selectAdminOrderMap.get("adminOrderSelectDTOList"));


///////////////////principal/////////////////////
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("$$$authentication : {}", authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("$$$userDetails : {}", userDetails);

        String username = userDetails.getUsername();
        log.info("$$$username : {}", username);


        ///////////////////principal/////////////////////

        return (List<AdminOrderSelectDTO>) selectAdminOrderMap.get("adminOrderSelectDTOList");
    }


}
