package com.hexkey.travelmaker.community.notices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoticesDTO {

    private long code;
    private long categoryCode;
    private CategoryDTO category;
    private String title;
    private String body;
    private Date registeredDate;
    private Date modifiedDate;
    private Date deletedDate;
    private String statusYN;

}

