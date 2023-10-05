package com.hexkey.travelmaker.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class MemberDTO {

    private int code;
    private String name;
    private int phone;
    private String email;
    private String id;
    private String pwd;
    private int tel;

    // 한 멤버는 여러 권한을 가질 수 있다.
    private List<MemberRoleDTO> memberRoleList;

}
