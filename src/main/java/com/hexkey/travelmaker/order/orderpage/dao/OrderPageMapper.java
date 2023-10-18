package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPageMapper {

    List<ProductDTO> selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

    Long insertFormOrder(OrderFormDTO orderFormDTO);
    Long insertFormShip(OrderFormDTO orderFormDTO);

    OrderDTO selectCurrentOrder(Long currentCode);
    ShipDTO selectCurrentShip(Long currentCode);

    int insertFormDetail(OrderDetailDTO orderDetailDTO);
    int insertPayment(OrderFormDTO orderFormDTO);
}
