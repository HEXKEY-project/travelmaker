package com.hexkey.travelmaker.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AddressDTO {

    private int addressCode;
    private String addressName;
    private int postalCode;
    private int memberCode;
    private String defaultAdr;
    private String optionalAdr;
    private String defaultYn;

}
