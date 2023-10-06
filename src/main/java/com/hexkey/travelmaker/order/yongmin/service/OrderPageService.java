package com.hexkey.travelmaker.order.yongmin.service;

import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import com.hexkey.travelmaker.order.yongmin.dao.OrderPageMapper;
import com.hexkey.travelmaker.order.yongmin.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderPageService {


    private final OrderPageMapper orderPageMapper;
    @Autowired
    public OrderPageService(OrderPageMapper orderPageMapper) {
        this.orderPageMapper = orderPageMapper;
    }


    public ProductDTO selectAllProduct() {

        ProductDTO orderPageProductDTO = orderPageMapper.selectAllProduct();
        return orderPageProductDTO;
    }


    @Transactional
    public String insertOrder(OrderDTO orderDTO) {
        int result = orderPageMapper.insertOrder(orderDTO);
        String resultMessage = "";

        if(result > 0) {
            resultMessage = "데이터 입력 완료!";
        } else {
            resultMessage = "데이터 입력 실패!";
        }

        return resultMessage;
    }


}
