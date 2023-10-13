package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private long orderCode;
    private long productCount;
    private long allProductPrice;
    private long optionCode;

}
