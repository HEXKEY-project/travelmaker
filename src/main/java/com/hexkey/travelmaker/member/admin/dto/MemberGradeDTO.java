package com.hexkey.travelmaker.member.admin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberGradeDTO {

    private int gradeCode; //회원등급코드
    private String gradeName; //회원등급이름
    private int mileageRate; //적립률

}
