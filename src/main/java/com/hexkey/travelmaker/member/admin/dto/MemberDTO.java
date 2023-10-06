package com.hexkey.travelmaker.member.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDTO {


    private Long memberCode;  //회원코드
    private String memberName; //이름
    private int phone; // 휴대폰번호
    private String email; //이메일
    private String memberId;  //아이디
    private String memberPwd; //비밀번호
    private String smsYn; //sns수신여부
    private String emailYn; //이메일수신여부
    private int mileage; //마일리지
    private String policyYn; //이용약관동의
    private String privateYn; //개인정보동의
    private String promotionYn; //쇼핑정보동의
    private MemberGradeDTO gradeCode; //회원등급
    private String loginType; //로그인타입
    private int tell; //일반전화
    private Date joinDay; //가입일

}
