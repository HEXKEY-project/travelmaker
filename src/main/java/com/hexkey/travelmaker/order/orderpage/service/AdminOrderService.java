package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dao.AdminOrderMapper;
import com.hexkey.travelmaker.order.orderpage.dto.AdminOrderSelectDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

        ///////////////////principal/////////////////////
        OrderFormDTO orderFormDTO = new OrderFormDTO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("$$$authentication : {}", authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("$$$userDetails : {}", userDetails);

        String memberName = userDetails.getUsername();
        log.info("$$$username : {}", memberName);

        orderFormDTO.setMemberName(memberName);

        log.info("$$$orderFormDTO : {}", orderFormDTO);

        ///////////////////principal/////////////////////


        List<AdminOrderSelectDTO> adminOrderSelectDTOList = adminOrderMapper.selectAdminOrder(searchCondition, searchValue, orderDate1, orderDate2, memberName);

        log.info("adminOrderSelectDTOList : {}" + adminOrderSelectDTOList);

        Map<String, Object> selectAdminOrderMap = new HashMap<>();
        selectAdminOrderMap.put("adminOrderSelectDTOList", adminOrderSelectDTOList);
        return selectAdminOrderMap;
    }

    public Map<String, Object> selectMemberOrder(String searchCondition, String searchValue, String orderDate1, String orderDate2) {

        ///////////////////principal/////////////////////
        OrderFormDTO orderFormDTO = new OrderFormDTO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("$$$authentication : {}", authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("$$$userDetails : {}", userDetails);

        String memberName = userDetails.getUsername();
        log.info("$$$username : {}", memberName);

        orderFormDTO.setMemberName(memberName);

        log.info("$$$orderFormDTO : {}", orderFormDTO);

        ///////////////////principal/////////////////////


        List<AdminOrderSelectDTO> adminOrderSelectDTOList = adminOrderMapper.selectMemberOrder(searchCondition, searchValue, orderDate1, orderDate2, memberName);

        log.info("adminOrderSelectDTOList : {}" + adminOrderSelectDTOList);

        Map<String, Object> selectAdminOrderMap = new HashMap<>();
        selectAdminOrderMap.put("adminOrderSelectDTOList", adminOrderSelectDTOList);
        return selectAdminOrderMap;
    }


}
