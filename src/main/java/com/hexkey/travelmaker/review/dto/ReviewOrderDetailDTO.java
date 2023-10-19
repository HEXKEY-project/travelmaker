package com.hexkey.travelmaker.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
public class ReviewOrderDetailDTO {

    private int orderCode;
    private int productCount;
    private int allProductPrice;
    private int optionCode;

}
