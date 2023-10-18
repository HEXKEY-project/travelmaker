package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class ShipDTO {

    private int shipCode;
    private String shipCompany;
    private int invoiceNo;
    private String shippedDate;
    private String shipStatus;
    private String recipent;
    private int postalCode;
    private int orderCode;
    private String defaultAdr;
    private String optionalAdr;
    private int phone;
    private String memo;

}
