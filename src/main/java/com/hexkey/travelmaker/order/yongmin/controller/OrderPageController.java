package com.hexkey.travelmaker.order.yongmin.controller;

import com.hexkey.travelmaker.order.yongmin.dto.OrderDTO;
import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import com.hexkey.travelmaker.order.yongmin.service.OrderPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class OrderPageController {

    private final OrderPageService orderPageService;
    @Autowired
    public OrderPageController(OrderPageService orderPageService) {
        this.orderPageService = orderPageService;
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

        ProductDTO orderPageProductDTO = orderPageService.selectAllProduct();

        model.addAttribute("option0", option0);
        model.addAttribute("option1", option1);
        model.addAttribute("option2", option2);
        model.addAttribute("orderPageProductDTO", orderPageProductDTO);

        ////////////////// inset 연습 코드 ///////////////
        OrderDTO orderDTO = new OrderDTO();

        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        orderDTO.setOrderDate("2022-02-02");
        orderDTO.setOrderStatus("32000");
        orderDTO.setMemberCode(32000);
        orderDTO.setCancelDate("2022-02-02");
        orderDTO.setConfirmDate("2022-02-02");
        orderDTO.setTotalPrice(32000);
        orderDTO.setProductPrice(32000);
        orderDTO.setShipPrice(32000);
        orderDTO.setMileageDiscountPrice(32000);

        String result = orderPageService.insertOrder(orderDTO);

        model.addAttribute("result", result);

        return "order/page";
    }

    @GetMapping("/map/map")
    public void map () {}

    @GetMapping("/order/pay")
    public void pay () {}

    @PostMapping("/order/test")
    @ResponseBody
    public String test(@RequestParam String t1,
                       @RequestParam String t2) {
        // t1 값으로 원하는 로직 수행
        return "결과: " + t1 + t2;
    }

    @GetMapping("/basket/basket")
    public void basket () {}

}
