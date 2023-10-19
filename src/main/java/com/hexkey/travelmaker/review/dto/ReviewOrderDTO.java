package com.hexkey.travelmaker.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReviewOrderDTO {

    private int orderCode;
    private Date orderDate;
    private String orderStatus;
    private int memberCode;
    private Date cancelDate;
    private Date confirmDate;
    private int totalPrice;
    private int shipPrice;
    private int mileageDiscountPrice;
    private String memberName;

}
