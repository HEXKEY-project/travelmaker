package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dto.*;
import com.hexkey.travelmaker.order.orderpage.dao.OrderPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderPageService {

    private final OrderPageMapper orderPageMapper;

    @Autowired
    public OrderPageService(OrderPageMapper orderPageMapper) {
        this.orderPageMapper = orderPageMapper;
    }


    public Map<String, Object> selectAllProduct() {

        List<ProductDTO> productDTO = orderPageMapper.selectAllProduct();
        Map<String, Object> productMAP = new HashMap<>();
        productMAP.put("productDTO", productDTO);
        return productMAP;
    }


    @Transactional
    public String insertOrder(OrderDTO orderDTO) {
        int result = orderPageMapper.insertOrder(orderDTO);
        String resultMessage = "";

        if (result > 0) {
            resultMessage = "데이터 입력 완료!";
        } else {
            resultMessage = "데이터 입력 실패!";
        }

        return resultMessage;
    }


    public Long insertFormOrder(OrderFormDTO orderFormDTO) {

        System.out.println("###체크 : " + orderFormDTO);


        Long result = orderPageMapper.insertFormOrder(orderFormDTO);

        System.out.println(orderFormDTO);

        System.out.println(orderFormDTO);
        Long resultShip = orderPageMapper.insertFormShip(orderFormDTO);
        System.out.println(orderFormDTO);

        Long currentCode = orderFormDTO.getOrderCode();
        System.out.println("currentCode : " + currentCode);
        System.out.println("orderFormDTO : " + orderFormDTO);
        System.out.println("size : " + orderFormDTO.getOptionCodes().size());

        for (int i = 0; i < orderFormDTO.getOptionCodes().size(); i++) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

            orderDetailDTO.setOrderCode(currentCode);
            System.out.println("orderDetailDTO2" + orderDetailDTO);
            orderDetailDTO.setOptionCode(Long.parseLong(orderFormDTO.getOptionCodes().get(i)));
            System.out.println("orderDetailDTO2" + orderDetailDTO);
            orderDetailDTO.setProductCount(Long.parseLong(orderFormDTO.getCounts().get(i)));
            System.out.println("orderDetailDTO2" + orderDetailDTO);
            orderDetailDTO.setAllProductPrice(Long.parseLong(orderFormDTO.getProductPrices().get(i)));
            System.out.println("orderDetailDTO2" + orderDetailDTO);


            int result2 = orderPageMapper.insertFormDetail(orderDetailDTO);
            System.out.println("@@@@@@@@@@@insertFormDetail결과" + result2);


        }

        int resultPay = orderPageMapper.insertPayment(orderFormDTO);
        System.out.println("@@@@@@@@@@@insertPayment결과" + resultPay);



        return currentCode;

    }

    public Map<String,Object> selectCurrentOrder(Long currentCode) {
        OrderDTO selectCurrentOrder = orderPageMapper.selectCurrentOrder(currentCode);
        System.out.println("서비스단 오더 출력 : " + selectCurrentOrder);

        ShipDTO selectCurrentShip = orderPageMapper.selectCurrentShip(currentCode);
        System.out.println("서비스단 배송 출력 : " + selectCurrentShip);

        Map<String,Object> selectSuccessMap = new HashMap<>();

        selectSuccessMap.put("selectCurrentOrder", selectCurrentOrder);
        selectSuccessMap.put("selectCurrentShip", selectCurrentShip);

        return selectSuccessMap;
    }


}
