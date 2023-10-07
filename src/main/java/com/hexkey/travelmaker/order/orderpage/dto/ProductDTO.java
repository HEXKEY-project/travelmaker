package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDTO {

    long categoryCode;
    String categoryName;
    long refCategoryCode;

}
