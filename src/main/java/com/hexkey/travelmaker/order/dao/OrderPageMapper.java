package com.hexkey.travelmaker.order.dao;

import com.hexkey.travelmaker.order.dto.OrderDTO;
import com.hexkey.travelmaker.order.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderPageMapper {

    ProductDTO selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

}
