package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderFormDTO {

    private Long orderCode;

    private String selectDefault;

    private String name;
    private String addressNumber;
    private String addressNew;
    private String addressDetail;
    private String tel1;
    private String tel2;
    private String tel3;
    private String phone1;
    private String phone2;
    private String phone3;
    private String email1;
    private String email2;
    private String memo;

    private String productName;
    private String productCount;
    private String productPrice;

    private String discount;

//    private String productPrice; 중복
    private String shipPrice;
//    private String discount; 중복
    private String totalPrice;

    private String bonus;


    ////////////// 번외

    private String orderDate;








}
