package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPageMapper {

    List<ProductDTO> selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

    List<OrderDTO> selectAdminOrder();

}
