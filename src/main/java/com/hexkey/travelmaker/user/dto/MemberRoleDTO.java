package com.hexkey.travelmaker.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberRoleDTO {

    private int memberCode;
    private int authorityCode;
    private AuthorityDTO authority;

}