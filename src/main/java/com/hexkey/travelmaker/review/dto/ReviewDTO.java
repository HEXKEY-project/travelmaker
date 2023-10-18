package com.hexkey.travelmaker.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class ReviewDTO {

    private int reviewCode;
    private int orderCode;
    private String reviewBody;
    private int rating;
    private Date registeredDate;
    private Date deletedDate;
    private String reviewStatus;
    private List<ReviewAttachDTO> reviewAttachList;

}
