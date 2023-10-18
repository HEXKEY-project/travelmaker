package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class AdminOrderSelectDTO {

    private int orderCode;
    private Date orderDate;
    private String orderStatus;
    private int totalPrice;
    private String recipent;
    private int phone;


}
