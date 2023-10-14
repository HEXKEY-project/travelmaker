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
import java.util.Map;


@Slf4j
@Controller
public class OrderPageController {

    private final OrderPageService orderPageService;
    @Autowired
    public OrderPageController(OrderPageService orderPageService) {
        this.orderPageService = orderPageService;
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

        Map<String,Object> selectSuccessMap = orderPageService.selectCurrentOrder(currentCode);

        OrderDTO selectCurrentOrder = (OrderDTO) selectSuccessMap.get("selectCurrentOrder");
        ShipDTO selectCurrentShip = (ShipDTO) selectSuccessMap.get("selectCurrentShip");

        log.info("Order 어디까지완료 ? {}", selectCurrentOrder);
//        String temp = selectCurrentOrder.getOrderDate();
//        log.info("temp {}", temp);
//        String temp2 = temp.substring(0, 10);
//
//        selectCurrentOrder.setOrderDate(temp2);
//
        log.info("Ship 어디까지완료 ? {}", selectCurrentShip);

        model.addAttribute("selectCurrentOrder", selectCurrentOrder);
        model.addAttribute("selectCurrentShip", selectCurrentShip);

        return "user/order/orderSuccess";
    }



    @PostMapping("/order/page")
    public String orderPage (@RequestParam String option0,
                             @RequestParam String option1,
                             @RequestParam int option2,
                             Model model) {
        // 오더페이지 띄울 정보 얻어오기

        // 로그인 되어있는 회원정보 dto : 이름,배송지,전화번호,이메일 / 적립금
        // 선택한 상품 dto :
        //
        System.out.println(option0);
        System.out.println(option1);
        System.out.println(option2);
        log.info("{}", option0);
        log.info("{}", option1);
        log.info("{}", option2);

        Map<String, Object> orderPageProductDTO = orderPageService.selectAllProduct();

        model.addAttribute("option0", option0);
        model.addAttribute("option1", option1);
        model.addAttribute("option2", option2);
        model.addAttribute("productDTO", orderPageProductDTO.get("productDTO"));

        ////////////////// inset 연습 코드 ///////////////
        OrderDTO orderDTO = new OrderDTO();

        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        orderDTO.setOrderDate("2022-02-02");
        orderDTO.setOrderStatus("32000");
        orderDTO.setMemberCode(32004);
        orderDTO.setCancelDate("2022-02-02");
        orderDTO.setConfirmDate("2022-02-02");
        orderDTO.setTotalPrice(5500);
        orderDTO.setProductPrice(52200);
        orderDTO.setShipPrice(32000);
        orderDTO.setMileageDiscountPrice(32000);

        String result = orderPageService.insertOrder(orderDTO);

        model.addAttribute("result", result);

        return "user/order/page";

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
    public String adminOrder (Model model) {

        Map<String, Object> selectAdminOrderMap = orderPageService.selectAdminOrder("0", "0","","");

        model.addAttribute("orderDTOs", selectAdminOrderMap.get("orderDTO"));

        return "admin/order/adminOrder";
    }

    @PostMapping("/admin/order")
    public String adminOrder (@RequestParam(required = false) String searchCondition,
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
