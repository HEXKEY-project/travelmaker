package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private Long orderCode;
    private Long productCount;
    private Long allProductPrice;
    private Long optionCode;

}
