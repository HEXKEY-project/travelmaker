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
import java.util.ArrayList;
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
    public Long orderForm(@ModelAttribute OrderFormDTO orderFormDTO,
                          @RequestParam(required = false) String optionCode_1,
                          @RequestParam(required = false) String optionCode_2,
                          @RequestParam(required = false) String optionCode_0,
                          @RequestParam(required = false) String count_1,
                          @RequestParam(required = false) String count_2,
                          @RequestParam(required = false) String count_0,
                          @RequestParam(required = false) String productPrice_1,
                          @RequestParam(required = false) String productPrice_2,
                          @RequestParam(required = false) String productPrice_0,
                          @RequestHeader("Merchant-Uid") String merchantUid) {

        List<String> optionCodesList = new ArrayList<>();
        List<String> countList = new ArrayList<>();
        List<String> productPriceList = new ArrayList<>();

        if (optionCode_0 != null) {
            optionCodesList.add(optionCode_0);
        }
        if (optionCode_1 != null) {
            optionCodesList.add(optionCode_1);
        }
        if (optionCode_2 != null) {
            optionCodesList.add(optionCode_2);
        }

        if (count_0 != null) {
            countList.add(count_0);
        }
        if (count_1 != null) {
            countList.add(count_1);
        }
        if (count_2 != null) {
            countList.add(count_2);
        }

        if (productPrice_0 != null) {
            productPriceList.add(productPrice_0);
        }
        if (productPrice_1 != null) {
            productPriceList.add(productPrice_1);
        }
        if (productPrice_2 != null) {
            productPriceList.add(productPrice_2);
        }

        orderFormDTO.setOptionCodes(optionCodesList);
        orderFormDTO.setCounts(countList);
        orderFormDTO.setProductPrices(productPriceList);

        orderFormDTO.setPayApiCode(merchantUid);
        orderFormDTO.setPayStatus("승인");

        log.info("체크 1 {}", orderFormDTO.getOptionCodes());
        log.info("체크 2 {}", orderFormDTO.getCounts());
        log.info("체크 3 {}", orderFormDTO.getProductPrices());

        log.info("merchantUid : {}", merchantUid); //
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






}
