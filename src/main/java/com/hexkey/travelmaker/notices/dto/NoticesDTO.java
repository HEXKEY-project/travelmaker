package com.hexkey.travelmaker.notices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoticesDTO {

    private int no;
    private long body;
    private Date registeredDate;
    private String title;
    private int memberCode;
    private Date modifiedDate;
    private Date deletedDate;
    private String statusYN;

}
