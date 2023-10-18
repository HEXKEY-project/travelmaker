package com.hexkey.travelmaker.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class MileageDTO {

    private int mileageCode; //적립금코드
    private int mileage; //적립금액
    private String mileageType;//적립금형태 Y 적립 N 차감
    private int memberCode; //회원코드
    private int orderCode; //주문코드
    private int reviewCode;//리뷰코드
    private String occuredType;//적립내용
    private Date occuredDate;//적립날짜 차감날짜

}
