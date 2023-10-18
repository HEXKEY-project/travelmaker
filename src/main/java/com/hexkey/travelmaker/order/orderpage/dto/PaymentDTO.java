package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO {

    private long payCode;
    private String payStatus;
    private String payDate;
    private long orderCode;
    private String payApiCode;

}
