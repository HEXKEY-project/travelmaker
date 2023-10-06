package com.hexkey.travelmaker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoticesDTO {

    private long no;
    private String body;
    private Date registeredDate;
    private String title;
    private Date modifiedDate;
    private Date deletedDate;
    private String statusYN;

}
