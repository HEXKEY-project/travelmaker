package com.hexkey.travelmaker.product.regist.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter @Setter @ToString
public class SelectCondition {

   private int categoryRoot;
   private int refCategoryCode;
   private int categoryCode;
   private String productName;
   private int firstPrice;
   private int secondPrice;
   private Date registDate;

   public SelectCondition(int categoryRoot, int refCategoryCode, int categoryCode, String productName, int firstPrice, int secondPrice, Date registDate) {
      this.categoryRoot = categoryRoot;
      this.refCategoryCode = refCategoryCode;
      this.categoryCode = categoryCode;
      this.productName = productName;
      this.firstPrice = firstPrice;
      this.secondPrice = secondPrice;
      this.registDate = registDate;
   }
}
