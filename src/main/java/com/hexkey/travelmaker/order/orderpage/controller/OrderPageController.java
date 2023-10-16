package com.hexkey.travelmaker.order.orderpage.controller;

import com.hexkey.travelmaker.order.orderpage.dto.HandleSuccessDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderFormDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ShipDTO;
import com.hexkey.travelmaker.order.orderpage.service.OrderPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
public class OrderPageController {

    private final OrderPageService orderPageService;

    @Autowired
    public OrderPageController(OrderPageService orderPageService) {
        this.orderPageService = orderPageService;
    }

    @GetMapping("/")
    public String orderMain () {
        return "orderMain";
    }


    //----------------------------- 고객 파트 ------------------------------------//
    @PostMapping("/order/orderForm")
    @ResponseBody
    public Long orderForm(@ModelAttribute OrderFormDTO orderFormDTO) {
        log.info("orderFormDTO : {}", orderFormDTO);

        LocalDate currentDate = LocalDate.now();
        String today = currentDate.toString();

        log.info("{}", orderFormDTO.getProductPrice());
        log.info("{}", orderFormDTO.getShipPrice());
        log.info("{}", orderFormDTO.getDiscount());


        String totalPrice = Integer.toString(Integer.parseInt(orderFormDTO.getProductPrice()) + Integer.parseInt(orderFormDTO.getShipPrice()) - Integer.parseInt(orderFormDTO.getDiscount()));
        log.info("{}", totalPrice);

        orderFormDTO.setTotalPrice(totalPrice);
        orderFormDTO.setOrderDate(today);


        Long currentCode = orderPageService.insertFormOrder(orderFormDTO);
        log.info("currentCode : {}", currentCode);


        return currentCode;
    }

    @PostMapping("/order/orderSuccess")
    @ResponseBody
    public String handleSuccess(@RequestBody HandleSuccessDTO handleSuccessDTO) {
        String imp_uid = handleSuccessDTO.getImp_uid();
        String merchant_uid = handleSuccessDTO.getMerchant_uid();

        log.info("imp_uid : {}", imp_uid);
        log.info("merchant_uid : {}", merchant_uid);

        return "김용민";
    }

    @GetMapping("/order/orderSuccess")
    public String successPage(@RequestParam String res,
                              Model model) {

        Long currentCode = Long.parseLong(res);

        Map<String, Object> selectSuccessMap = orderPageService.selectCurrentOrder(currentCode);

        OrderDTO selectCurrentOrder = (OrderDTO) selectSuccessMap.get("selectCurrentOrder");
        ShipDTO selectCurrentShip = (ShipDTO) selectSuccessMap.get("selectCurrentShip");

        log.info("Order 어디까지완료 ? {}", selectCurrentOrder);
        String temp = selectCurrentOrder.getOrderDate();
        log.info("temp {}", temp);
        String temp2 = temp.substring(0, 10);

        selectCurrentOrder.setOrderDate(temp2);

        log.info("Ship 어디까지완료 ? {}", selectCurrentShip);

        model.addAttribute("selectCurrentOrder", selectCurrentOrder);
        model.addAttribute("selectCurrentShip", selectCurrentShip);

        return "user/order/orderSuccess";
    }


    @PostMapping("/order/test")
    @ResponseBody
    public String test(@RequestParam String t1,
                       @RequestParam String t2) {
        // t1 값으로 원하는 로직 수행
        return "결과: " + t1 + t2;
    }


    //----------------------------- 관리자 파트 ------------------------------------//

    @GetMapping("/admin/order")
    public String adminOrder(Model model) {

        Map<String, Object> selectAdminOrderMap = orderPageService.selectAdminOrder("0", "0", "", "");

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

        Map<String, Object> selectAdminOrderMap = orderPageService.selectAdminOrder(searchCondition, searchValue, orderDate1, orderDate2);

        model.addAttribute("orderDTOs", selectAdminOrderMap.get("orderDTO"));

        return "admin/order/adminOrder";
    }


}
