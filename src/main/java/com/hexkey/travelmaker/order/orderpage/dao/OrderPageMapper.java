package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.OrderFormDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ShipDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPageMapper {

    List<ProductDTO> selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

    List<OrderDTO> selectAdminOrder(String searchCondition, String searchValue, String orderDate1, String orderDate2);

    Long insertFormOrder(OrderFormDTO orderFormDTO);
    Long insertFormShip(OrderFormDTO orderFormDTO);

    OrderDTO selectCurrentOrder(Long currentCode);
    ShipDTO selectCurrentShip(Long currentCode);
}
