package com.hexkey.travelmaker.product.regist.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class SelectCondition {

   private int categoryCode;
   private String categoryName;
   private int refCategoryCode;
   private String productName;
   private int price1;
   private int price2;
   private Date registDate;
}
