package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDTO {

    int productSeq;
    String productName;
    int price;
    String registeredDate;
    String modifiedDate;
    int categoryCode;
    String serialNo;
    String orderableStatus;

}
