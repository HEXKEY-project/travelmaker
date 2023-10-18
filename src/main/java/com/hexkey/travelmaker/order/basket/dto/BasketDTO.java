package com.hexkey.travelmaker.order.basket.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class BasketDTO {

    private long basketCount;
    private long memberCode;
    private long optionCode;

}
