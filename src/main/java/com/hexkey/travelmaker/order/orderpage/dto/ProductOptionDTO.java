package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductOptionDTO {

    String optionName;
    int optionCode;
    int productSeq;
    int refOptionCode;

}
