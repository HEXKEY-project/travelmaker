package com.hexkey.travelmaker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCategoryDTO {

    private Long categoryCode;
    private String categoryName;
    private Long refCategoryCode;
}
