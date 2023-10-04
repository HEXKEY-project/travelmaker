package com.hexkey.travelmaker.admin.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductOptionDTO {

    private String optionName;
    private Long optionCode;
    private Long productSeq;
    private Long refOptionCode;
}
