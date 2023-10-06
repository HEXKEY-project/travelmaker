package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderDTO {

    private long orderCode; // PK
    private String orderDate; // not null
    private String orderStatus; // not null
    private long memberCode; // not null
    private String cancelDate;
    private String confirmDate;
    private long totalPrice; // not null
    private long productPrice; // not null
    private long shipPrice; // not null
    private long mileageDiscountPrice; // not null
}
