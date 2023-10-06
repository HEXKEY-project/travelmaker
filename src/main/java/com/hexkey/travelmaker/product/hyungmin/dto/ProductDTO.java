package com.hexkey.travelmaker.product.hyungmin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductDTO {

    private Long productSeq;
    private String productName;
    private Long price;
    private Date registDate;
    private Date modifyDate;
    private Long categoryCode;
    private ProductCategoryDTO productCategory;
    private String serialNo;
    private List<ProductOptionDTO> productOption;
    private String status;
    private List<FileDTO> fileList;
}
