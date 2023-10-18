package com.hexkey.travelmaker.order.orderpage.dao;

import com.hexkey.travelmaker.order.orderpage.dto.AdminOrderSelectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminOrderMapper {

    List<AdminOrderSelectDTO> selectAdminOrder(String searchCondition, String searchValue, String orderDate1, String orderDate2);

}
