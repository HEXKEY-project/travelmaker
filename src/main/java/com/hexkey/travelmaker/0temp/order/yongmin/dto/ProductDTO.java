package com.hexkey.travelmaker.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDTO {

    long productSeq;
    String productName;
    long price;
    String registeredDate;
    String modifiedDate;
    long categoryCode;
    String serialNo;
    String orderableStatus;

}
