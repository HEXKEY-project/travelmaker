package com.hexkey.travelmaker.admin.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductOptionDTO {

    private String optionName;
    private Long optionCode;
    private List<ProductOptionDTO> productOptionList;
    private Long productSeq;
    private Long refOptionCode;
}
