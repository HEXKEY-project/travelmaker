package com.hexkey.travelmaker.order.yongmin.dao;

import com.hexkey.travelmaker.order.yongmin.dto.ProductDTO;
import com.hexkey.travelmaker.order.yongmin.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderPageMapper {

    ProductDTO selectAllProduct();

    int insertOrder(OrderDTO orderDTO);

}
