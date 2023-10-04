package com.hexkey.travelmaker.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter @ToString
public class OrderDTO {

    long orderCode; // PK
    String orderDate; // not null
    String orderStatus; // not null
    long memberCode; // not null
    String cancelDate;
    String confirmDate;
    long totalPrice; // not null
    long productPrice; // not null
    long shipPrice; // not null
    long mileageDiscountPrice; // not null

}
