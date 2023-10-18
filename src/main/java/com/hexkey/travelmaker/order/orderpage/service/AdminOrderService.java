package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dao.AdminOrderMapper;
import com.hexkey.travelmaker.order.orderpage.dto.AdminOrderSelectDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdminOrderService {

    private final AdminOrderMapper adminOrderMapper;
    @Autowired
    public AdminOrderService (AdminOrderMapper adminOrderMapper) {
        this.adminOrderMapper = adminOrderMapper;
    }





    public Map<String, Object> selectAdminOrder(String searchCondition, String searchValue, String orderDate1, String orderDate2) {

        List<AdminOrderSelectDTO> adminOrderSelectDTOList = adminOrderMapper.selectAdminOrder(searchCondition, searchValue, orderDate1, orderDate2);

        log.info("adminOrderSelectDTOList : {}" + adminOrderSelectDTOList);

        Map<String, Object> selectAdminOrderMap = new HashMap<>();
        selectAdminOrderMap.put("adminOrderSelectDTOList", adminOrderSelectDTOList);
        return selectAdminOrderMap;
    }


}
