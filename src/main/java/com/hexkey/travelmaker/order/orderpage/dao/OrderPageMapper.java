package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderPageMapper {

    ProductDTO selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

}
